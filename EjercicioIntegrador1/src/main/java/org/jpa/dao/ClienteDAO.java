package org.jpa.dao;

import org.jpa.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertPersona(Cliente cliente) {
        String query = "INSERT INTO Cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, cliente.getIdCliente()); // idPersona
            ps.setString(2, cliente.getNombre()); // nombre
            ps.setString(3, cliente.getEmail()); // email
            ps.executeUpdate();
            System.out.println("Persona insertada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    public Cliente find(Integer pk) {
        String query = "SELECT c.nombre, c.email" +
                "FROM Cliente c " +
                "WHERE p.idPersona = ?";
        Cliente clienteById = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, pk); // Establecer el parámetro en la consulta SQL
            rs = ps.executeQuery();
            if (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");

                // Crear una nueva instancia de Persona con los datos recuperados de la consulta
                clienteById = new Cliente(pk, nombre,email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return clienteById;
    }

    /*
    public PersonaDTO findPersonaDTO(Integer pk) {
        String query = "SELECT p.nombre, p.edad, d.ciudad, d.calle, d.numero " +
                "FROM Persona p " +
                "JOIN Direccion d ON p.idDireccion = d.idDireccion " +
                "WHERE p.idPersona = ?";
        Persona personaById = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        PersonaDTO personaDTO = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, pk); // Establecer el parámetro en la consulta SQL
            rs = ps.executeQuery();
            if (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String ciudad = rs.getString("ciudad");
                String calle = rs.getString("calle");
                int numero = rs.getInt("numero");

                // Crear una nueva instancia de PersonaDTO con los datos recuperados de la consulta
                personaDTO = new PersonaDTO(nombre, edad, ciudad, calle, numero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return personaDTO;
    }



    public boolean update(Persona dao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    public List<Persona> selectList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectList'");
    }*/

}
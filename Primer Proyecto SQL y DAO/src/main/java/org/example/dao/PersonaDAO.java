package org.example.dao;

import org.example.modelo.Persona;

import java.sql.*;
import java.util.List;

public class PersonaDAO extends Conexion implements IPersonaDAO {
    protected Connection conn;

    public PersonaDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertPersona(Persona persona) {
        String query = "INSERT INTO Persona (idPersona, nombre, edad) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, persona.getId()); // idPersona
            ps.setString(2, persona.getNombre()); // nombre
            ps.setInt(3, persona.getYear()); // edad
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

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public List<Persona> getPersonas() {
        return null;
    }


    public Persona getPersonaByID(int id) {
        String query = "SELECT p.nombre, p.edad, p.idDireccion " +
                "FROM Persona p " +
                "WHERE p.idPersona = ?";
        Persona personaById = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id); // Establecer el parámetro en la consulta SQL
            rs = ps.executeQuery();
            if (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");

                // Crear una nueva instancia de Persona con los datos recuperados de la consulta
                personaById = new Persona(id, nombre, edad);
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
        return personaById;
    }

}

    /*@Override
        public void insert(Persona persona) throws SQLException {
        try{
           this.conectar();

            createTables(this.con); //Metodo para crear tablas dah
            add(this.con, 1, "Olivia", 19);
            add(this.con, 2, "Santiago", 23);
        }
        catch (Exception e) {
            e.printStackTrace();
            this.desconectar();
        } finally {
            this.desconectar();
        }
    }

    private void add(Connection con, int id, String name, int years) throws SQLException {
        String insert = "INSERT INTO person VALUES(?,?,?)";
        PreparedStatement ps = this.con.prepareStatement(insert);

        ps.setInt(1, id); //parametro 1, id ..
        ps.setString(2, name);
        ps.setInt(3, years);
        ps.executeUpdate();
        ps.close();
        con.commit(); //commit con la insercion :)
    }


    private static void createTables(Connection con) throws SQLException {
        String table = "CREATE TABLE person(" +
                "id INT," +
                "nombre VARCHAR(25)," +
                "edad INT," +
                "PRIMARY KEY(id))";
        con.prepareStatement(table).execute();
        con.commit();
    }


    @Override
    public void update(Persona persona) throws SQLException {
        try{
            this.conectar();
            PreparedStatement ps = this.con.prepareStatement("UPDATE person SET nombre = ? WHERE id = ?");
            ps.setString(1, ((Persona) persona).getNombre());
            ps.setInt(2, ((Persona) persona).getId());
            ps.executeUpdate();
            con.commit();  // Confirma los cambios
            ps.close();
        }
        catch (Exception e){
            this.desconectar();
        }
    }

    @Override
    public void delete(Persona persona) throws SQLException {
        try{
            this.conectar();
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM person WHERE id = ?");
            ps.setInt(1, ((Persona) persona).getId());
            ps.executeUpdate();
        }
        catch (Exception e){
            this.desconectar();
        }
    }

    @Override
    public Persona getById(int id) {
        Persona persona = new Persona();
        persona.setId(id);
        return persona;
    }

    @Override
    public List<Persona> getAll() throws SQLException {
        List<Persona> lista = new ArrayList<>();

        try{
            this.conectar();
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM person");
            lista = new ArrayList<>();

            ResultSet rs = ps.executeQuery(); //no entiendo que es ResultSet

            while (rs.next()){
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                lista.add(persona);
            }
            rs.close();
            ps.close();
        }
        catch (Exception e){
            this.desconectar();
        }
        return lista;
    }

    @Override
    public RowSet selectCustomersRS() {
        return null;
    }

    @Override
    public Collection selectCustomers() {
        return List.of();
    }
    */



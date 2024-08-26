package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException("Error loading database driver: " + driver, e);
        }

        //conexion a la base de datos
        String uri = "jdbc:mysql://localhost:3307/arquidb";

        //Creamos conexion
        try {
            Connection con = DriverManager.getConnection(uri, "root", "root");
            con.setAutoCommit(false);

            createTables(con); //Metodo para crear tablas dah
            addPerson(con, 1, "Olivia", 19);
            addPerson(con, 2, "Santiago", 23);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addPerson(Connection con, int id, String name, int years) throws SQLException {
        String insert = "INSERT INTO person VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);

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

}
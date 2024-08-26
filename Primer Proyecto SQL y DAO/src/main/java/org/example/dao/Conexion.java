package org.example.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

        protected Connection con;
        String driver = "com.mysql.cj.jdbc.Driver";
        String uri = "jdbc:mysql://localhost:3307/arquidb";


        private final String USER = "root";
        private final String PASS = "root";

        //Creamos conexion
        public void conectar(){
            try {
                Class.forName(driver).getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException("Error loading database driver: " + driver, e);
            }

            try {
                con = DriverManager.getConnection(uri, USER, PASS);
                con.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public void desconectar() throws SQLException {
        if (con != null){ //si esta llena, conexion exitosa
            if (!con.isClosed()){ //si esta abierta
                con.close();
            }
        }
    }
}

/*
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
    */

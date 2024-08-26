package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Select {

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

                String select = "select * from person";
                PreparedStatement ps = con.prepareStatement(select);
                ResultSet rs = ps.executeQuery(); //Resultados
                while (rs.next()) { //mientras haya siguiente.. (cursor)
                    System.out.println(
                            rs.getString(1) + " "
                            + rs.getString(2) + " "
                            + rs.getString(3));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Select {

        public static void main(String[] args) {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            String uri = "jdbc:derby:MyDerbyDd;create=true";


            try {
                Class.forName(driver).getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException("Error loading database driver: " + driver, e);
            }


            try {
                Connection con = DriverManager.getConnection(uri);
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

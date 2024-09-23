package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Delete {

    public static void main(String[] args) {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String uri = "jdbc:derby:MyDerbyDd;create=true";
        String deleteQuery = "DELETE FROM person WHERE id = ?";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException("Error loading database driver: " + driver, e);
        }

        try (Connection con = DriverManager.getConnection(uri);
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            // Eliminar segun un id .
            int idToDelete = 1; // Ejemplo de ID del registro a eliminar
            ps.setInt(1, idToDelete);

            int rowsAffected = ps.executeUpdate(); // Ejecuta la sentencia DELETE
            System.out.println("Number of rows deleted: " + rowsAffected);

        } catch (SQLException e) {
            throw new RuntimeException("Error executing delete operation", e);
        }
    }
}

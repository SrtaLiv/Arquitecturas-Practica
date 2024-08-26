package org.example;

import org.example.dao.IDAOFactory;
import org.example.dao.PersonaDAO;
import org.example.modelo.Persona;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        IDAOFactory<Persona> personaDAO = new PersonaDAO();

        Persona p1 = new Persona(1, "Olivia", 23);
        personaDAO.insert(p1);
    }
}
package org.example;

import org.example.dao.PersonaDAO;
import org.example.dto.PersonaDTO;
import org.example.factory.AbstractFactory;
import org.example.modelo.Persona;
import org.example.utils.HelperMySQL;

public class Main {
        public static void main(String[] args) throws Exception {
            HelperMySQL dbMySQL = new HelperMySQL();
            dbMySQL.dropTables();
            dbMySQL.createTables();
            dbMySQL.populateDB();
            dbMySQL.closeConnection();

            AbstractFactory chosenFactory = AbstractFactory.getDAOFactory(1);
            System.out.println();
            System.out.println("////////////////////////////////////////////");
            System.out.println("////////////////////////////////////////////");
            System.out.println();
          //  DireccionDAO direccion = chosenFactory.getDireccionDAO();
            PersonaDAO persona = chosenFactory.getPersonaDAO();


            System.out.println("Busco una Persona por id: ");
            Persona personaById = persona.getPersonaByID(2);
            System.out.println(personaById);
            System.out.println("////////////////////////////////////////////");
            System.out.println("////////////////////////////////////////////");
            System.out.println("Lista de direcciones: ");
//        List<Direccion> listadoDirecciones = direccion.selectList();
//        System.out.println(listadoDirecciones);


            System.out.println("////////////////////////////////////////////");
            System.out.println("////////////////////////////////////////////");

//        Persona p = new Persona(6,"Sergio",50,2);
//        persona.insertPersona(p);

          //  PersonaDTO personaDTO = persona.findPersonaDTO(2);
          //  System.out.println(personaDTO);
        }
    }


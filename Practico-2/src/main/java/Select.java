import model.Direccion;
import model.Persona;
import model.Socio;
import model.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        /** CONSIGNA 2
         * 2) En base al ejercicio anterior, implementar las siguientes consultas:
         * a) recuperar todas las personas asignadas a un turno. //JUAN!
         * b) recuperar todas las personas asignadas a un turno, y marcar cuales de ellas son socios.
         * c) recuperar todas las personas que viven en una ciudad predeterminada.
         * d) En los casos anteriores, evaluar que sucede al utilizar las opciones FetchType.LAZY
         * FetchType.EAGER en las anotaciones. ¿Nota alguna diferencia?, ¿a qué se debe?
         */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String jpqlTurno = "SELECT p FROM Persona p JOIN p.turnos t";
        Query query = em.createQuery(jpqlTurno);
        List<Persona> resultados = query.getResultList();
        System.out.println("Personas asignadas a un turno"); //ana y susana
        for(Persona p : resultados) {
            System.out.println(p.getNombre());
        }

        System.out.println("Consulta para obtener personas asignadas a turnos y si son socios");
        String jpql = "SELECT p, (CASE WHEN s.persona IS NOT NULL THEN 'Sí' ELSE 'No' END) AS esSocio " +
                "FROM Persona p " +
                "JOIN p.turnos t " +
                "LEFT JOIN Socio s ON s.persona.id = p.id";
        Query a = em.createQuery(jpql);
        List<Object[]> results = a.getResultList();

        for (Object[] result : results) {
            Persona persona = (Persona) result[0];
            String esSocio = (String) result[1];
            System.out.println(persona.getNombre() + " - Socio: " + esSocio);
        }

        System.out.println("Recuperar todas las personas que viven en una ciudad predeterminada.");
        String jpqlCiudad = "SELECT p FROM Persona p WHERE p.domicilio.ciudad = :culo";
        //:ciudad, estás diciendo "en este lugar de la consulta, colocaré el valor que asignaré después a través de código."
        Query ciudadQuery = em.createQuery(jpqlCiudad);
        ciudadQuery.setParameter("culo", "Tandil"); // Filtrar por la ciudad "Tandil"
        List<Persona> resultList = ciudadQuery.getResultList();
        for (Persona persona : resultList) {
            System.out.println(persona.getNombre());
        }


        em.getTransaction().commit();
        em.close();
        emf.close();

    }


}

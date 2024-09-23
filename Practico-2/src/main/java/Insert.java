import model.Direccion;
import model.Persona;
import model.Socio;
import model.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class Insert {
    public static void main(String[] args) {
        /** CONSIGNA 2
         * 2) En base al ejercicio anterior, implementar las siguientes consultas:
         * a) recuperar todas las personas asignadas a un turno.
         * b) recuperar todas las personas asignadas a un turno, y marcar cuales de ellas son socios.
         * c) recuperar todas las personas que viven en una ciudad predeterminada.
         * d) En los casos anteriores, evaluar que sucede al utilizar las opciones FetchType.LAZY o
         * FetchType.EAGER en las anotaciones. ¿Nota alguna diferencia?, ¿a qué se debe?
         */

        //EntityManagerFactory: fabrica de entity manager
        //(nombre del persistence.xml)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");

        //interactua con bases de datos, inser, delete..
        EntityManager em = emf.createEntityManager();

        //empieza la transaccion, agrupan varias operaciones en una sola unidad de trabajo.
        // Si sale bien, se confirma (commit) la transacción; Si ocurre un error, se puede deshacer (rollback).
        em.getTransaction().begin();

        Direccion d = new Direccion("Tandil", "Sarmiento 772");
        Direccion o = new Direccion("Olavarria", "Sarmiento 772");

        em.persist(d);
        em.persist(o);

        Persona j = new Persona(2, "Juan", 25, d);
        Persona a = new Persona(3, "Ana", 22, d);
        Persona s = new Persona(4, "Susana", 23, d);

        em.persist(j);
        em.persist(a);
        em.persist(s);

        Socio sj = new Socio(j, "Basico");
        Socio sa = new Socio(a, "Premium");
        Socio se = new Socio(a, "Aburrido");
        em.persist(sj);
        em.persist(sa);
        em.persist(se);

        //asignando turnos a Ana y Susana
        Turno t = new Turno(new Timestamp(System.currentTimeMillis()));
        t.getJugadores().add(j); //juan tiene turno
        t.getJugadores().add(a);
        em.persist(t);


        em.getTransaction().commit();
        em.close();
        emf.close();

    }


}

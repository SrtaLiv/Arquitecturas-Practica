import models.Equipo;
import models.Jugador;
import models.Torneo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        /*
        3) Suponga un sistema para gestionar torneos de futbol 7, donde las principales entidades son:
        Equipo, Jugador, y Torneo. Cada equipo incluye 7 jugadores (uno de ellos debe ser arquero),
        2
        hasta 3 suplentes, y 1 director técnico. Cada equipo puede o no representar a una entidad o
        firma comercial. Los jugadores desempeñan una posición fija dentro del equipo (por ej.,
        arquero, defensa, mediocampo, delantera). Un jugador solo puede estar fichado en un
        equipo. Un torneo tiene un nombre e incluye un conjunto prefijado de equipos.
        a) realizar un modelamiento orientado a objetos de las entidades y sus relaciones.
        b) diseñar un DER que permita mapear el modelo orientado a objetos anterior.
        c) implementar el mapeo entre a) y b) utilizando anotaciones de JPA.
        d) implementar servicios para altas, bajas y modificaciones de las distintas entidades
        e) implementar servicios para agregar jugadores a equipos, e inscribir equipos a torneos
        f) implementar servicios para buscar todos los jugadores de un equipo, y todos los
        jugadores de un torneo.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Crear un torneo
            Torneo libertadores = new Torneo();
            libertadores.setNombre("Libertadores");

            // Crear un equipo
            Equipo river = new Equipo();
            river.setNombre("River Plate");
            river.setDirectorTecnico("Marcelo Gallardo");
            river.setEntidadRepresentada("Club Atlético River Plate");

            // Crear jugadores y asignarlos al equipo
            List<Jugador> jugadores = new ArrayList<>();
            Jugador j1 = new Jugador("Riquelme", "Defensor", river);
           // em.persist(j1);
            j1.setNombre("Riquelme");
            j1.setPosicion("Defensor");
            j1.setEquipo(river);
            jugadores.add(j1);

            Jugador j2 = new Jugador();
            j2.setNombre("Ortega");
            j2.setPosicion("Delantero");
            j2.setEquipo(river);
            jugadores.add(j2);

            river.setJugadores(jugadores);

            // Persistir los objetos
            em.persist(libertadores);
            em.persist(river);
            for (Jugador jugador : jugadores) {
                em.persist(jugador);
            }

            // Asociar el equipo al torneo
            libertadores.getEquipos().add(river);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

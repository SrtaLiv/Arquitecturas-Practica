package service;

import models.Jugador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JugadorService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");

    public void crearJugador(Jugador jugador) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(jugador);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Jugador obtenerJugador(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarJugador(Jugador jugador) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(jugador);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarJugador(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Jugador jugador = em.find(Jugador.class, id);
            if (jugador != null) {
                em.remove(jugador);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Jugador> listarJugadores() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT j FROM Jugador j", Jugador.class).getResultList();
        } finally {
            em.close();
        }
    }
}
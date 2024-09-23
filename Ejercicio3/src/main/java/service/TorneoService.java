package service;

import models.Torneo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.EntityManager;
import java.util.List;

public class TorneoService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");

    public void crearTorneo(Torneo torneo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(torneo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Torneo obtenerTorneo(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Torneo.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarTorneo(Torneo torneo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(torneo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarTorneo(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Torneo torneo = em.find(Torneo.class, id);
            if (torneo != null) {
                em.remove(torneo);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Torneo> listarTorneos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Torneo t", Torneo.class).getResultList();
        } finally {
            em.close();
        }
    }
}
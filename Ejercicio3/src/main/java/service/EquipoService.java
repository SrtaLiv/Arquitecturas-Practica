package service;

import models.Equipo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EquipoService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");

    public void crearEquipo(Equipo equipo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(equipo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Equipo obtenerEquipo(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarEquipo(Equipo equipo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(equipo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarEquipo(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Equipo equipo = em.find(Equipo.class, id);
            if (equipo != null) {
                em.remove(equipo);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Equipo> listarEquipos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();
        } finally {
            em.close();
        }
    }
}
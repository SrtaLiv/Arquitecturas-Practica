import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Vacio {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Vaciar las tablas
            em.createNativeQuery("DELETE FROM Direccion").executeUpdate();
            em.createNativeQuery("DELETE FROM Persona").executeUpdate();
            em.createNativeQuery("DELETE FROM Socio").executeUpdate();
            em.createNativeQuery("DELETE FROM Turno").executeUpdate();

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

package pe.edu.i202224541.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224541.identity.Country;

public class JPARemove {
    public static void main(String[] args) {

        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            // Comenzar la transacción
            em.getTransaction().begin();

            // Buscar el país con código "XYZ" (el país imaginario)
            Country country = em.find(Country.class, "EZ");

            if (country != null) {
                // Eliminar el país (y todas las entidades relacionadas debido a la cascada)
                em.remove(country);
                System.out.println("El país y sus ciudades y lenguajes han sido eliminados.");
            } else {
                System.out.println("No se encontró el país con el código 'XYZ'.");
            }

            // Confirmar la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Si hay un error, hacer rollback
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}

package pe.edu.i202224541.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224541.identity.City;
import pe.edu.i202224541.identity.Country;

import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {
    public static void main(String[] args) {
        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            // Buscar el país con código "PER" (Perú)
            Country peru = em.find(Country.class, "PER");

            if (peru != null) {
                System.out.println("Ciudades de Perú con población > 700k:");

                // Filtrar las ciudades que tienen una población mayor a 700,000
                List<City> cities = peru.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .collect(Collectors.toList());

                // Imprimir los nombres de las ciudades filtradas
                cities.forEach(city -> System.out.println(city.getName()));
            } else {
                System.out.println("No se encontró el país con el código 'PER'.");
            }
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}

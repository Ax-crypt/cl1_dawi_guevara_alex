package pe.edu.i202224541.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224541.identity.City;
import pe.edu.i202224541.identity.Country;
import pe.edu.i202224541.identity.CountryLanguage;

import java.util.Arrays;
import java.util.List;

public class JPAPersist {
    public static void main(String[] args) {

        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
        // Crear un país imaginario
        Country country = new Country();
        country.setCode("EZ");
        country.setName("Eriz");
        country.setContinent("Sudamerica");
        country.setRegion("Sudamérica");
        country.setSurfaceArea(1285216.0);
        country.setIndependenceYear(1821);
        country.setPopulation(32971854);
        country.setLifeExpectancy(76.3);
        country.setGnp(153700.0);
        country.setGnpOld(120000.0);
        country.setLocalName("República del Eriz");
        country.setGovernmentForm("Democracia");
        country.setHeadOfState("Alex Guevara");
        country.setCapital(1);
        country.setCode2("ER");

        //insertar cicudes
            City city1 = new City();
            city1.setName("Ciudad Imaginaria 1");
            city1.setDistrict("Distrito 1");
            city1.setPopulation(500000);
            city1.setCountry(country);

            City city2 = new City();
            city2.setName("Ciudad Imaginaria 2");
            city2.setDistrict("Distrito 2");
            city2.setPopulation(300000);
            city2.setCountry(country);

            City city3 = new City();
            city3.setName("Ciudad Imaginaria 3");
            city3.setDistrict("Distrito 3");
            city3.setPopulation(200000);
            city3.setCountry(country);

            // Asignar las ciudades al país


            // Crear los lenguajes nativos
            CountryLanguage language1 = new CountryLanguage();
            language1.setCountry(country);
            language1.setLanguage("Imaginariano");
            language1.setIsOfficial(CountryLanguage.OfficialStatus.T);
            language1.setPercentage(80.0);

            CountryLanguage language2 = new CountryLanguage();
            language2.setCountry(country);
            language2.setLanguage("Imaginario Moderno");
            language2.setIsOfficial(CountryLanguage.OfficialStatus.F);
            language2.setPercentage(20.0);

            // Asignar  al país
            country.setCities(Arrays.asList(city1, city2, city3));
            country.setCountryLanguages(Arrays.asList(language1, language2));

            // Persistir el país, las ciudades y los lenguajes en una sola llamada
            em.persist(country);
            // Confirmar la transacción
            em.getTransaction().commit();
            System.out.println("El país y las ciudades han sido persistidos exitosamente.");
        } catch (Exception e) {
        e.printStackTrace();
    } finally {
        em.close();
        emf.close();
    }
    }
}

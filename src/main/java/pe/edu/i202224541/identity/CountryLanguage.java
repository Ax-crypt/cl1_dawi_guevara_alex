package pe.edu.i202224541.identity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country country;

    @Id
    @Column(name = "Language", length = 30)
    private String language;

    @Column(name = "IsOfficial", columnDefinition = "enum('T', 'F')")
    @Enumerated(EnumType.STRING)
    private OfficialStatus isOfficial;

    @Column(name = "Percentage")
    private double percentage;

    // Getters and setters

    public enum OfficialStatus {
        T, F
    }

    public CountryLanguage() {
    }

    public CountryLanguage(Country country, String language, OfficialStatus isOfficial, double percentage) {
        this.country = country;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public OfficialStatus getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(OfficialStatus isOfficial) {
        this.isOfficial = isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "country=" + country +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                '}';
    }
}


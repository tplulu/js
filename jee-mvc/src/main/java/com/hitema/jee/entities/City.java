package com.hitema.jee.entities;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(name = "city")
public class City {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "city_id", nullable = false)
    private Long id;

    private String city ;

    @ManyToOne
        @JoinColumn(name = "country_id")
    private Country country;


    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("id=").append(id);
        sb.append(", city='").append(city).append('\'');
        sb.append(", country=").append(country);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }

    public String searchCities(String city) {
        List<City> cities = city.findByName(name);
        model.addAttribute("cities", cities);
        return "search";
    }
}

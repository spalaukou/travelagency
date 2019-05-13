package model.entity;

import java.util.Objects;

/**
 * Hotel is an entity that is contained in the Tour entity.
 * Contains the characteristics of the Hotel.
 *
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 * @see Tour
 */

public class Hotel extends BaseEntity {

    private String name;
    private String country;
    private String city;
    private int star;
    private String meal;
    private int person;

    public Hotel() {
    }

    public Hotel(String name, String country, String city, int star, String meal, int person) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.star = star;
        this.meal = meal;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return star == hotel.star &&
                person == hotel.person &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(country, hotel.country) &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(meal, hotel.meal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, city, star, meal, person);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", star=" + star +
                ", meal='" + meal + '\'' +
                ", person=" + person +
                '}';
    }
}

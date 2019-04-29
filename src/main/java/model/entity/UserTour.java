package model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class UserTour {
    private String country;
    private String city;
    private String hotelName;
    private int star;
    private String meal;
    private int person;
    private int night;
    private String transportType;
    private int cost;
    private float hot;
    private int userCost;

    public UserTour() {
    }

    public UserTour(String country, String city, String hotelName, int star, String meal, int person, int night,
                    String transportType, int cost, float hot, int userCost) {
        this.country = country;
        this.city = city;
        this.hotelName = hotelName;
        this.star = star;
        this.meal = meal;
        this.person = person;
        this.night = night;
        this.transportType = transportType;
        this.cost = cost;
        this.hot = hot;
        this.userCost = userCost;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getHot() {
        return hot;
    }

    public void setHot(float hot) {
        this.hot = hot;
    }

    public int getUserCost() {
        return userCost;
    }

    public void setUserCost() {
        this.userCost = (int) (cost * hot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTour userTour = (UserTour) o;
        return star == userTour.star &&
                person == userTour.person &&
                night == userTour.night &&
                cost == userTour.cost &&
                Float.compare(userTour.hot, hot) == 0 &&
                userCost == userTour.userCost &&
                Objects.equals(country, userTour.country) &&
                Objects.equals(city, userTour.city) &&
                Objects.equals(hotelName, userTour.hotelName) &&
                Objects.equals(meal, userTour.meal) &&
                Objects.equals(transportType, userTour.transportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, hotelName, star, meal, person, night, transportType, cost, hot, userCost);
    }

    @Override
    public String toString() {
        return country + " " +
                city + " " +
                hotelName + " " +
                star + " " +
                meal + " " +
                person + " " +
                night + " " +
                transportType + " " +
                cost + " " +
                hot + " " +
                userCost;
    }
}

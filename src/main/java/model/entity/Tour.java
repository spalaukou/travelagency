package model.entity;

import model.entity.old.Customer;

import java.util.Objects;

/**
 * Tour is a entity, that can buy a Customer.
 * Tour has a price (USD), can be a hot(Tour Agent can change this variable,
 * is 1.0 by default), has a type(vacation, excursion, shopping) and
 * description(info about hotel is String).
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 * @see Customer
 */

public class Tour extends BaseEntity {
    private String name;
    private Hotel hotel;
    private int night;
    private Transport.Type transportType;
    private int cost;
    private float hot;

    public Tour() {
    }

    public Tour(String name, Hotel hotel, int night, Transport.Type transportType, int cost, float hot) {
        this.name = name;
        this.hotel = hotel;
        this.night = night;
        this.transportType = transportType;
        this.cost = cost;
        this.hot = hot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public Transport.Type getTransportType() {
        return transportType;
    }

    public void setTransportType(Transport.Type transportType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return night == tour.night &&
                cost == tour.cost &&
                Float.compare(tour.hot, hot) == 0 &&
                Objects.equals(name, tour.name) &&
                Objects.equals(hotel, tour.hotel) &&
                transportType == tour.transportType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hotel, night, transportType, cost, hot);
    }
}

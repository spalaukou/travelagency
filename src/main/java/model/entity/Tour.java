package model.entity;


import java.util.Objects;

/**
 * Tour is an entity, that can buy a Customer, and manage an Agent. Tour has a type
 * (vacation, excursion, shopping), a Hotel, a night variable, a transport variable,
 * a cost (in USD), can be a hot (Tour Agent can change this variable, is 1.0 by default),
 * and total price (depends on a hot characteristic and on the User's personal discount).
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 * @see User
 * @see Hotel
 * @see Transport
 */

public class Tour extends BaseEntity {
    private String type;
    private Hotel hotel;
    private int night;
    private Transport transport;
    private int cost;
    private float hot;
    private int totalPrice;

    public Tour() {
    }

    public Tour(String type, Hotel hotel, int night, Transport transport, int cost, float hot) {
        this.type = type;
        this.hotel = hotel;
        this.night = night;
        this.transport = transport;
        this.cost = cost;
        this.hot = hot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return night == tour.night &&
                cost == tour.cost &&
                Float.compare(tour.hot, hot) == 0 &&
                Objects.equals(type, tour.type) &&
                Objects.equals(hotel, tour.hotel) &&
                Objects.equals(transport, tour.transport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, hotel, night, transport, cost, hot);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "type='" + type + '\'' +
                ", hotel=" + hotel +
                ", night=" + night +
                ", transport=" + transport +
                ", cost=" + cost +
                ", hot=" + hot +
                '}';
    }
}

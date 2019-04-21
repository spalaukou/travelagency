package model.entity;

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

public class Tour {
    private double price;
    private double hot;
    private String type;
    private String description;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHot() {
        return hot;
    }

    public void setHot(double hot) {
        this.hot = hot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Double.compare(tour.price, price) == 0 &&
                Double.compare(tour.hot, hot) == 0 &&
                Objects.equals(type, tour.type) &&
                Objects.equals(description, tour.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, hot, type, description);
    }
}

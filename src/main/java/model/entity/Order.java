package model.entity;

import java.util.Objects;

/**
 * Order is a class, that contains information
 * about User and what Tour he has bought.
 *
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 * @see User
 * @see Tour
 */

public class Order extends BaseEntity {
    private User user;
    private Tour tour;
    private int totalPrice;

    public Order() {
    }

    public Order(User user, Tour tour, int totalPrice) {
        this.user = user;
        this.tour = tour;
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
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
        Order order = (Order) o;
        return totalPrice == order.totalPrice &&
                Objects.equals(user, order.user) &&
                Objects.equals(tour, order.tour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, tour, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", tour=" + tour +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

package model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class Order extends BaseEntity {
    private User user;
    private Tour tour;

    public Order() {
    }

    public Order(User user, Tour tour) {
        this.user = user;
        this.tour = tour;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) &&
                Objects.equals(tour, order.tour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, tour);
    }
}

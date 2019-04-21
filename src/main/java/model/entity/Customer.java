package model.entity;

import java.util.List;
import java.util.Objects;

/**
 * Customer is a User, that can buy a Tour.
 * Customer's money are saved in 'balance' variable(USD).
 * Customer's tour are saved in 'tours' - a List of Tours.
 * Customer may have a discount. It depends on the total cost of the tours he bought.
 * Variable 'discount' is 1.0 by default.
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 * @see Tour
 */

public class Customer extends AbstractEntity {
    private String login;
    private String password;
    private double balance;
    private double discount;
    private List<Tour> tours;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.balance, balance) == 0 &&
                Double.compare(customer.discount, discount) == 0 &&
                login.equals(customer.login) &&
                password.equals(customer.password) &&
                tours.equals(customer.tours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, balance, discount, tours);
    }
}

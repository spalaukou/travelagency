package model.entity;

import java.util.Objects;

/**
 * User can be a Travel Agent(can manage Tours - create, change
 * and delete) and set 'hot' variable in float to special Tours)
 * and can be a Customer(can buy Tours).
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 * @see Tour
 */

public class User extends BaseEntity {

    public enum Type {
        AGENT, CUSTOMER;
    }

    private Type type;
    private String login;
    private String password;
    private int balance;
    private float discount;

    public User() {
    }

    public User(Type type, String login, String password, int balance, float discount) {
        this.type = type;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.discount = discount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return balance == user.balance &&
                Float.compare(user.discount, discount) == 0 &&
                type == user.type &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, login, password, balance, discount);
    }

    @Override
    public String toString() {
        return "User{" +
                "type=" + type +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                ", id=" + id +
                '}';
    }
}

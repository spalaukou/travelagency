package model.entity;

import java.util.Objects;

/**
 * User is a User, that can be a Travel Agent(can manage Tours
 * (create, change, delete) and set 'hot' variable in double
 * to special Tours) and can be a Consumer(can buy Tours).
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 * @see Tour
 */

public class User extends AbstractEntity {

    public enum Type {
        AGENT, CONSUMER;
    }

    private Type type;
    private String login;
    private String password;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return type == user.type &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, login, password);
    }
}

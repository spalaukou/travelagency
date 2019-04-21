package model.entity;

import java.util.Objects;

/**
 * TourAgent is a User, that can manage Tours(create, change, delete),
 * and set 'hot' variable in double to special Tours.
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 * @see Tour
 */

public class TourAgent extends AbstractEntity {
    private String login;
    private String password;

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
        TourAgent tourAgent = (TourAgent) o;
        return Objects.equals(login, tourAgent.login) &&
                Objects.equals(password, tourAgent.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}

package model.entity;

import java.util.Objects;

/**
 * Small entity with types of Transport.
 *
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class Transport extends BaseEntity {
    private String type;

    public Transport() {
    }

    public Transport(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(type, transport.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "type='" + type + '\'' +
                '}';
    }

}

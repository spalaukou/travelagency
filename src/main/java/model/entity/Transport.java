package model.entity;

import java.util.Objects;

/**
 * Small entity with types of Transport.
 *
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class Transport extends BaseEntity {
    public String Type;

    public Transport() {
    }

    public Transport(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(Type, transport.Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "Type='" + Type + '\'' +
                '}';
    }

    public enum Type {
        CAR, TRAIN, AIRPLANE, SHIP;
    }
}

package model.entity;

import java.util.Objects;

/**
 * Basic parent class for all entities of project.
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 */

public class BaseEntity {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

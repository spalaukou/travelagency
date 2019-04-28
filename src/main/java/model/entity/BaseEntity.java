package model.entity;

/**
 * Basic class for all entities.
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
}

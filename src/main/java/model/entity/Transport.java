package model.entity;

/**
 * Small entity with types of Transport.
 *
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class Transport extends BaseEntity {
    public enum Type {
        CAR, TRAIN, AIRPLANE, SHIP;
    }
}

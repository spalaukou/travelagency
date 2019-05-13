package model.entity.builder;

import model.entity.Order;
import model.entity.Tour;

/**
 * The Factory, that provides entity builders.
 *
 * @author Stanislau Palaukou on 09.05.2019
 * @project TravelAgency
 */

public class BuilderFactory {
    private static final BuilderFactory INSTANCE = new BuilderFactory();
    private final EntityBuilder<Tour> tourBuilder = new TourBuilder();
    private final EntityBuilder<Order> orderBuilder = new OrderBuilder();

    private BuilderFactory() {}

    public static BuilderFactory getInstance() {
        return INSTANCE;
    }

    public EntityBuilder<Tour> getTourBuilder() {
        return tourBuilder;
    }

    public EntityBuilder<Order> getOrderBuilder() {
        return orderBuilder;
    }
}

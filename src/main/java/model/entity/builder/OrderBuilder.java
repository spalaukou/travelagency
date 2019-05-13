package model.entity.builder;

import model.entity.*;
import model.logic.dal.db_connection.DBConstantContainer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for building the Order from ResultSet.
 *
 * @author Stanislau Palaukou on 09.05.2019
 * @project TravelAgency
 */

public class OrderBuilder implements EntityBuilder<Order> {

    /**
     * Builds an Order entity.
     *
     * @param resultSet
     * @return Order entity.
     * @throws SQLException
     */
    @Override
    public Order build(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt(DBConstantContainer.ORDER_ID_ORDER));

        User user = new User();
        user.setId(resultSet.getInt(DBConstantContainer.ID_USER));
        user.setLogin(resultSet.getString(DBConstantContainer.USER_LOGIN));
        user.setDiscount(resultSet.getFloat(DBConstantContainer.USER_DISCOUNT));
        order.setUser(user);

        BuilderFactory builderFactory = BuilderFactory.getInstance();
        EntityBuilder tourBuilder = builderFactory.getTourBuilder();
        Tour tour = (Tour) tourBuilder.build(resultSet);

        order.setTour(tour);

        order.setTotalPrice(resultSet.getInt(DBConstantContainer.ORDER_TOTAL_PRICE));

        return order;
    }
}

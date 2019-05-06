package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class BalanceValidator implements Validator {
    private TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
    private Connection connection;

    @Override
    public boolean validate(HttpServletRequest request) {
        String tourID = request.getParameter(ConstantContainer.TOUR_ID);
        String login = (String) request.getSession().getAttribute(ConstantContainer.LOGIN);
        float discount = (float) request.getSession().getAttribute(ConstantContainer.DISCOUNT);

        try {
            connection = tourConnectionPool.getConnection();
            if(connection != null) {
                int balance = getBalance(login);
                int price = getPrice(tourID);

                int totalPrice = (int) (price * discount);

                if(totalPrice <= balance) {
                    return true;
                }

                tourConnectionPool.returnConnection(connection);
            } else {
                //tourconnectionpoolexc
                return false;
            }
        } catch (TourConnectionPoolException e) {
            //log
        }

        return false;
    }

    private int getBalance(String login) throws TourConnectionPoolException {
        int balance = ConstantContainer.WRONG_BALANCE;

        try (PreparedStatement statement =
                     connection.prepareStatement(DBRequestContainer.GET_USER_BALANCE_REQUEST)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                balance =  Integer.parseInt(resultSet.getString(DBConstantContainer.USER_BALANCE));
            }
        } catch (SQLException e) {
            throw new TourConnectionPoolException(e);
        }
        return balance;
    }

    private int getPrice(String tourID) throws TourConnectionPoolException {
        int price = ConstantContainer.WRONG_PRICE;

        try (PreparedStatement statement =
                     connection.prepareStatement(DBRequestContainer.GET_TOUR_COST_HOT_REQUEST)) {
            statement.setString(1, tourID);
            ResultSet resultSet = statement.executeQuery();

            int cost;
            float hot;

            while (resultSet.next()) {
                cost = Integer.parseInt(resultSet.getString(DBConstantContainer.TOUR_COST));
                hot = Float.parseFloat(resultSet.getString(DBConstantContainer.TOUR_HOT));

                price = (int) (cost * hot);
            }
        } catch (SQLException e) {
            throw new TourConnectionPoolException(e);
        }
        return price;
    }
}

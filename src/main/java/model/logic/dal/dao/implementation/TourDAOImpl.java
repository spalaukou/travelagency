package model.logic.dal.dao.implementation;

import model.entity.Tour;
import model.entity.builder.BuilderFactory;
import model.entity.builder.EntityBuilder;
import model.logic.dal.dao.TourDAO;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Tour DAO.
 *
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public class TourDAOImpl implements TourDAO {

    /**
     * Executes DataBase query and creates a new Tour by requested parameters.
     *
     * @param tourType
     * @param hotelID
     * @param hotelNight
     * @param transport
     * @param tourCost
     * @param tourHot
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public void createTour(String tourType, String hotelID, String hotelNight, String transport, String tourCost, String tourHot)
            throws TourConnectionPoolException, DAOSQLException {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.CREATE_TOUR_REQUEST)) {

                statement.setString(1, tourType);
                statement.setString(2, hotelID);
                statement.setString(3, hotelNight);
                statement.setString(4, transport);
                statement.setString(5, tourCost);
                statement.setString(6, tourHot);

                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
    }

    /**
     * Executes DataBase query and updates the Tour by requested parameters.
     *
     * @param tourID
     * @param tourCost
     * @param tourHot
     * @throws TourConnectionPoolException
     * @throws DAOSQLException
     */
    @Override
    public void updateTour(String tourID, String tourCost, String tourHot)
            throws TourConnectionPoolException, DAOSQLException {
        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        if (connection != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.UPDATE_TOUR_REQUEST)) {

                statement.setString(1, tourCost);
                statement.setString(2, tourHot);
                statement.setString(3, tourID);

                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }
        }
    }

    /**
     * Executes DataBase query and creates a Tour list by requested country and User's discount.
     *
     * @param country
     * @param discount
     * @return List of Tours
     * @throws DAOSQLException
     * @throws TourConnectionPoolException
     */
    @Override
    public List<Tour> getToursByCountry(String country, float discount)
            throws DAOSQLException, TourConnectionPoolException {
        List<Tour> tours;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        try (PreparedStatement statement =
                     connection.prepareStatement(DBRequestContainer.GET_TOURS_BY_COUNTRY_REQUEST)) {

            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();

            tours = createTourList(resultSet, discount);

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        } finally {
            tourConnectionPool.returnConnection(connection);
        }

        return tours;
    }

    /**
     * Executes DataBase query and creates a list of all Tours.
     *
     * @param discount
     * @return List of Tours
     * @throws DAOSQLException
     * @throws TourConnectionPoolException
     */
    @Override
    public List<Tour> getAllTours(float discount)
            throws DAOSQLException, TourConnectionPoolException {
        List<Tour> tours;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

        try (PreparedStatement statement =
                     connection.prepareStatement(DBRequestContainer.GET_ALL_TOURS_REQUEST)) {

            ResultSet resultSet = statement.executeQuery();

            tours = createTourList(resultSet, discount);

        } catch (SQLException e) {
            throw new DAOSQLException(e);
        } finally {
            tourConnectionPool.returnConnection(connection);
        }

        return tours;
    }

    /**
     * Executes DataBase query and get a Tour price by requested Tour ID.
     *
     * @param tourID
     * @return price of the Tour
     * @throws DAOSQLException
     * @throws TourConnectionPoolException
     */
    @Override
    public int getPrice(String tourID) throws DAOSQLException, TourConnectionPoolException {
        int price = DBConstantContainer.WRONG_TOUR_PRICE;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
        Connection connection = tourConnectionPool.getConnection();

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
            throw new DAOSQLException(e);
        } finally {
            tourConnectionPool.returnConnection(connection);
        }
        return price;
    }

    /**
     * Creates a list of Tours by calling the Tour Builder.
     *
     * @param resultSet
     * @param discount
     * @return List of Tours
     * @throws SQLException
     */
    private List<Tour> createTourList(ResultSet resultSet, float discount) throws SQLException {
        List<Tour> tours = new ArrayList<>();
        BuilderFactory builderFactory = BuilderFactory.getInstance();
        EntityBuilder<Tour> tourBuilder = builderFactory.getTourBuilder();

        while (resultSet.next()) {
            Tour tour = tourBuilder.build(resultSet);
            tour.setTotalPrice((int) (tour.getCost() * tour.getHot() * discount));

            tours.add(tour);
        }
        return tours;
    }
}

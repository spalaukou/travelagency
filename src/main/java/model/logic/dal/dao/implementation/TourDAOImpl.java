package model.logic.dal.dao.implementation;

import model.entity.Hotel;
import model.entity.Tour;
import model.entity.Transport;
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
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public class TourDAOImpl implements TourDAO {

    @Override
    public List<Tour> getToursByCountry(String country, float discount) throws DAOSQLException {
        List<Tour> tours;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();

        try {
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
        } catch (TourConnectionPoolException e) {
            throw new DAOSQLException(e);
        }

        return tours;
    }

    @Override
    public List<Tour> getAllTours(float discount) throws DAOSQLException {
        List<Tour> tours;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();

        try {
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
        } catch (TourConnectionPoolException e) {
            throw new DAOSQLException(e);
        }

        return tours;
    }

    private List<Tour> createTourList(ResultSet resultSet, float discount) throws SQLException {
        List<Tour> tours = new ArrayList<>();

        while (resultSet.next()) {
            Tour tour = new Tour();
            tour.setId(resultSet.getInt(DBConstantContainer.TOUR_ID_TOUR));
            tour.setName(resultSet.getString(DBConstantContainer.TOUR_NAME));

            Hotel hotel = new Hotel();
            hotel.setId(resultSet.getInt(DBConstantContainer.HOTEL_ID_HOTEL));
            hotel.setName(resultSet.getString(DBConstantContainer.HOTEL_NAME));
            hotel.setCountry(resultSet.getString(DBConstantContainer.HOTEL_COUNTRY));
            hotel.setCity(resultSet.getString(DBConstantContainer.HOTEL_CITY));
            hotel.setStar(resultSet.getInt(DBConstantContainer.HOTEL_STAR));
            hotel.setMeal(resultSet.getString(DBConstantContainer.HOTEL_MEAL));
            hotel.setPerson(resultSet.getInt(DBConstantContainer.HOTEL_PERSON));
            tour.setHotel(hotel);

            tour.setNight(resultSet.getInt(DBConstantContainer.TOUR_NIGHT));

            Transport transport = new Transport();
            transport.setId(resultSet.getInt(DBConstantContainer.TRANSPORT_ID_TRANSPORT));
            transport.setType(resultSet.getString(DBConstantContainer.TRANSPORT_TYPE));
            tour.setTransport(transport);

            tour.setCost(resultSet.getInt(DBConstantContainer.TOUR_COST));
            tour.setHot(resultSet.getFloat(DBConstantContainer.TOUR_HOT));
            tour.setTotalPrice((int) (tour.getCost() * tour.getHot() * discount));

            tours.add(tour);
        }
        return tours;
    }
}

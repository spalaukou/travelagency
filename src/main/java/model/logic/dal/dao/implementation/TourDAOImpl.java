package model.logic.dal.dao.implementation;

import model.ConstantContainer;
import model.entity.Tour;
import model.logic.dal.dao.TourDAO;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public class TourDAOImpl implements TourDAO {

    @Override
    public List<Tour> getToursByCountry(String country) throws DAOSQLException {
        List<Tour> tours;

        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();

        try {
            Connection connection = tourConnectionPool.getConnection();

            String query;

            if(country.equals("all")) {
                query = DBRequestContainer.GET_ALL_TOURS_REQUEST;
            } else {
                query = DBRequestContainer.GET_TOURS_BY_COUNTRY_REQUEST;
            }

            try (PreparedStatement statement =
                         connection.prepareStatement(DBRequestContainer.GET_TOURS_BY_COUNTRY_REQUEST)) {

                statement.setString(1, country);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Tour tour = new Tour();

                    //
                }

            } catch (SQLException e) {
                throw new DAOSQLException(e);
            } finally {
                tourConnectionPool.returnConnection(connection);
            }

        } catch (TourConnectionPoolException e) {
            throw new DAOSQLException(e);
        }


        return null;
    }
}

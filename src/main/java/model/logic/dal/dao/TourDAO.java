package model.logic.dal.dao;

import model.entity.Tour;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.util.List;

/**
 * Interface for Tour DAO implementation.
 *
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public interface TourDAO {

    List<Tour> getToursByCountry(String country, float discount) throws DAOSQLException, TourConnectionPoolException;

    List<Tour> getAllTours(float discount) throws DAOSQLException, TourConnectionPoolException;

    int getPrice(String tourID) throws DAOSQLException, TourConnectionPoolException;

    void createTour(String tourType, String hotelID, String hotelNight, String transport, String tourCost, String tourHot) throws TourConnectionPoolException, DAOSQLException;

    void updateTour(String tourID, String tourCost, String tourHot) throws TourConnectionPoolException, DAOSQLException;
}

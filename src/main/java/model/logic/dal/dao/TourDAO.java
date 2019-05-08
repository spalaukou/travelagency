package model.logic.dal.dao;

import model.entity.Tour;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.util.List;

/**
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public interface TourDAO {

    List<Tour> getToursByCountry(String country, float discount) throws DAOSQLException, TourConnectionPoolException;

    List<Tour> getAllTours(float discount) throws DAOSQLException, TourConnectionPoolException;

    int getPrice(String tourID) throws DAOSQLException, TourConnectionPoolException;
}

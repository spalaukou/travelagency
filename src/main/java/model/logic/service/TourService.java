package model.logic.service;

import model.entity.Tour;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;

import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public interface TourService {

    List<Tour> getToursByCountry(String country, float discount) throws ServiceSQLException, DataSourceException;

    List<Tour> getAllTours(float discount) throws ServiceSQLException, DataSourceException;

    int getPrice(String tourID) throws ServiceSQLException, DataSourceException;
}

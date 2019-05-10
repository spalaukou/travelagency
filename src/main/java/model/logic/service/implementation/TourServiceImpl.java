package model.logic.service.implementation;

import model.entity.Tour;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.TourDAO;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.TourService;

import java.util.List;

/**
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public class TourServiceImpl implements TourService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TourDAO tourDAO = daoFactory.getTourDAO();

    @Override
    public void createTour(String tourType, String hotelID, String hotelNight, String transport, String tourCost, String tourHot)
            throws ServiceSQLException, DataSourceException {
        try {
            tourDAO.createTour(tourType, hotelID, hotelNight, transport, tourCost, tourHot);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public void updateTour(String tourID, String tourCost, String tourHot)
            throws ServiceSQLException, DataSourceException {
        try {
            tourDAO.updateTour(tourID, tourCost, tourHot);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public List<Tour> getToursByCountry(String country, float discount)
            throws ServiceSQLException, DataSourceException {
        List<Tour> tours;

        try {
            tours = tourDAO.getToursByCountry(country, discount);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        }
        return tours;
    }

    @Override
    public List<Tour> getAllTours(float discount) throws ServiceSQLException, DataSourceException {
        List<Tour> tours;

        try {
            tours = tourDAO.getAllTours(discount);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        }

        return tours;
    }

    @Override
    public int getPrice(String tourID) throws ServiceSQLException, DataSourceException {
        int price;

        try {
            price = tourDAO.getPrice(tourID);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        }

        return price;
    }
}

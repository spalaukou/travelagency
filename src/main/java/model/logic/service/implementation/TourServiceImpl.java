package model.logic.service.implementation;

import model.entity.Tour;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.TourDAO;
import model.logic.exception.technical.DAOSQLException;
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
    public List<Tour> getToursByCountry(String country, float discount) {
        List<Tour> tours = null;

        try {
            tours = tourDAO.getToursByCountry(country, discount);
        } catch (DAOSQLException e) {
            //log
        }

        return tours;
    }

    @Override
    public List<Tour> getAllTours(float discount) {
        List<Tour> tours = null;

        try {
            tours = tourDAO.getAllTours(discount);
        } catch (DAOSQLException e) {
            //log
        }

        return tours;
    }
}

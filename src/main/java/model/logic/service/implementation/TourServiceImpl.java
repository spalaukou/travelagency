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
    public List<Tour> getToursByCountry(String country) {
        List<Tour> tours;

        try {
            tours = tourDAO.getToursByCountry(country);
        } catch (DAOSQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package model.logic.dal.dao;

import model.logic.dal.dao.implementation.ShowAllToursDAOImpl;
import model.logic.dal.dao.implementation.TourDAOImpl;
import model.logic.dal.dao.implementation.UserDAOImpl;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();
    private final TourDAO tourDAO = new TourDAOImpl();

    //del
    private final ShowAllToursDAO showAllToursDAO = new ShowAllToursDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TourDAO getTourDAO() {
        return tourDAO;
    }

    //del
    public ShowAllToursDAO getShowAllToursDAO() {
        return showAllToursDAO;
    }
}

package model.logic.service.implementation;

import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.UserDAO;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.UserService;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserServiceImpl implements UserService {

    @Override
    public int signUp(String login, String password) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();

        int userID = DBConstantContainer.WRONG_RESPONSE;

        try {
            userID = userDAO.signUp(login, password);
        } catch (TourConnectionPoolException | DAOSQLException e) {
            e.printStackTrace();
        }

        return userID;
    }
}

package model.logic.service.implementation;

import model.entity.User;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.UserDAO;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserServiceImpl implements UserService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public int signUp(String login, String password) {
        int userID = DBConstantContainer.WRONG_RESPONSE;

        try {
            userID = userDAO.signUp(login, password);
        } catch (TourConnectionPoolException | DAOSQLException e) {
            e.printStackTrace();
        }

        return userID;
    }

    @Override
    public User signIn(HttpServletRequest request) {
        User user = userDAO.signIn(request);

        return user;
    }
}

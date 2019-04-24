package model.logic.service.implementation;

import model.logic.DAL.UserDAO;
import model.logic.DAL.implementation.UserDAOImpl;
import model.logic.service.UserService;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserServiceImpl implements UserService {

    @Override
    public int signUp(String login, String password) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.signUp(login, password);
        return 0;
    }
}

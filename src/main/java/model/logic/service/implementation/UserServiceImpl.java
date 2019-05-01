package model.logic.service.implementation;

import model.entity.User;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.UserDAO;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.exception.technical.TourConnectionPoolException;
import model.logic.service.UserService;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserServiceImpl implements UserService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public void signUp(String login, String password) {
        try {
            userDAO.signUp(login, password);
        } catch (TourConnectionPoolException | DAOSQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User signIn(String login, String password) throws DataSourceException, ServiceSQLException {
        User user;
        try {
            user = userDAO.signIn(login, password);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException();
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }
        return user;
    }
}

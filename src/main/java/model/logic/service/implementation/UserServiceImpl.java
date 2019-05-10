package model.logic.service.implementation;

import model.entity.User;
import model.logic.dal.dao.DAOFactory;
import model.logic.dal.dao.UserDAO;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.logical.DataSourceException;
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
    public void signUp(String login, String password) throws ServiceSQLException, DataSourceException {

        try {
            userDAO.signUp(login, password);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
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

    @Override
    public int getID(String login) throws DataSourceException, ServiceSQLException {
        int userID;

        try {
            userID = userDAO.getID(login);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException();
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return userID;
    }

    @Override
    public String getPassword(String login) throws DataSourceException, ServiceSQLException {
        String password;

        try {
            password = userDAO.getPassword(login);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException();
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return password;
    }

    @Override
    public int getBalance(String login) throws DataSourceException, ServiceSQLException {
        int balance;

        try {
            balance = userDAO.getBalance(login);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException();
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return balance;
    }

    @Override
    public void setBalance(String userID, int balance) throws DataSourceException, ServiceSQLException {
        try {
            userDAO.setBalance(userID, balance);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException();
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }
    }

    @Override
    public float setDiscount(String userID) throws DataSourceException, ServiceSQLException {
        float discount;

        try {
            discount = userDAO.setDiscount(userID);
        } catch (TourConnectionPoolException e) {
            throw new DataSourceException();
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return discount;
    }
}

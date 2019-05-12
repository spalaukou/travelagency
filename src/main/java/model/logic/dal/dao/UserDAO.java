package model.logic.dal.dao;

import model.entity.User;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;

import java.sql.Connection;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface UserDAO {

    void signUp(String login, String password) throws TourConnectionPoolException, DAOSQLException;

    User signIn(String login, String password) throws TourConnectionPoolException, DAOSQLException;

    int getID(String login) throws TourConnectionPoolException, DAOSQLException;

    String getPassword(String login) throws TourConnectionPoolException, DAOSQLException;

    int getBalance(String login) throws DAOSQLException, TourConnectionPoolException;

    void setBalance(Connection connection, String userID, int balance) throws TourConnectionPoolException, DAOSQLException;

    float setDiscount(Connection connection, String userID) throws TourConnectionPoolException, DAOSQLException;



}

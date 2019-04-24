package model.logic.DAL.implementation;

import model.logic.DAL.DBconnection.TourConnectionPool;
import model.logic.DAL.UserDAO;
import model.logic.exception.technical.DBconnectionException;

import javax.sql.DataSource;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserDAOImpl implements UserDAO {

    @Override
    public int signUp(String login, String password) throws DBconnectionException {
        //TourConnectionPool pool = TourConnectionPool.getInstance();

        DataSource connection = TourConnectionPool.getConnection();


        return 0;
    }
}

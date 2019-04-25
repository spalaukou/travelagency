package model.logic.DAL.implementation;

import model.logic.DAL.DBconnection.TourConnectionPool;
import model.logic.DAL.UserDAO;
import model.logic.exception.technical.DBconnectionException;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class UserDAOImpl implements UserDAO {

    private static String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/student?useTimezone=true&serverTimezone=UTC";
    private static String DATABASE_USER = "root";
    private static String DATABASE_PASSWORD = "root";

    //TODO
    private static String SQL = "INSERT INTO `tours`.`customer` (`firstname`, `lastname`) VALUES ('a', 'a');";


    @Override
    public int signUp(String login, String password) throws DBconnectionException {
        //TourConnectionPool pool = TourConnectionPool.getInstance();
        //DataSource connection = TourConnectionPool.getConnection();


        Connection connection = null;

        try {
            Class.forName(JDBC_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();

            String sql = SQL;

            ResultSet resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

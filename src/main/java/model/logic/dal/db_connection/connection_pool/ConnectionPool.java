package model.logic.dal.db_connection.connection_pool;

import model.logic.dal.db_connection.DBConstantContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class ConnectionPool {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DBConstantContainer.JDBC_MYSQL_DRIVER);

            connection = DriverManager.getConnection(
                    DBConstantContainer.DATABASE_URL,
                    DBConstantContainer.DATABASE_USER,
                    DBConstantContainer.DATABASE_PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            //log
        }
        return connection;
    }
}

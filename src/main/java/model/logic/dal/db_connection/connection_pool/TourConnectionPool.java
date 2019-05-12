package model.logic.dal.db_connection.connection_pool;

import model.ConstantContainer;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.exception.technical.TourConnectionPoolException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 */

public final class TourConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(TourConnectionPool.class);

    private static TourConnectionPool INSTANCE = new TourConnectionPool();

    private BlockingQueue<Connection> allConnections;
    private String driver;
    private String url;
    private String login;
    private String password;
    private int connectionPoolSize;
    private boolean isLocked;

    private TourConnectionPool() {
        this.driver = DBConstantContainer.JDBC_MYSQL_DRIVER;
        this.url = DBConstantContainer.DATABASE_URL;

        this.login = DBConstantContainer.DATABASE_LOGIN;
        this.password = DBConstantContainer.DATABASE_PASSWORD;

        this.connectionPoolSize = DBConstantContainer.CONNECTIONS_COUNT;

        try {
            initializePool();
        } catch (TourConnectionPoolException e) {
            LOGGER.error(ConstantContainer.CONNECTION_POOL_ERR_MSG, e);
        }
    }

    public static TourConnectionPool getInstance() {
        return INSTANCE;
    }

    private void initializePool() throws TourConnectionPoolException {
        isLocked = false;

        try {

            Class.forName(driver);
            allConnections = new ArrayBlockingQueue<>(connectionPoolSize);

            for (int i = 0; i < connectionPoolSize; i++) {
                Connection connection = DriverManager.getConnection(url, login, password);
                allConnections.add(connection);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new TourConnectionPoolException(e);
        }
    }

    public Connection getConnection() throws TourConnectionPoolException {
        Connection connection;

        if(this.isLocked){
            return null;
        }

        try {

            connection = allConnections.take();

        } catch (InterruptedException e) {
            throw new TourConnectionPoolException(e);
        }

        return connection;
    }

    public void returnConnection(Connection connection) throws TourConnectionPoolException {

        try {

            connection.setAutoCommit(true);

        } catch (SQLException e) {
            throw new TourConnectionPoolException(e);
        }

        allConnections.add(connection);
    }
}

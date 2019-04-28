package model.logic.dal.db_connection.connection_pool;

import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.exception.technical.TourConnectionPoolException;

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
    private static TourConnectionPool INSTANCE = new TourConnectionPool();
    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenConnections;
    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;
    private boolean isBlocked;

    private TourConnectionPool() {
        this.driverName = DBConstantContainer.JDBC_MYSQL_DRIVER;
        this.url = DBConstantContainer.DATABASE_URL;

        this.user = DBConstantContainer.DATABASE_USER;
        this.password = DBConstantContainer.DATABASE_PASSWORD;

        this.poolSize = DBConstantContainer.MAX_CONNECTIONS;

        try {
            initializePool();
        } catch (TourConnectionPoolException e) {
            //log
        }
    }

    public static TourConnectionPool getInstance() {
        return INSTANCE;
    }

    public void initializePool() throws TourConnectionPoolException {
        isBlocked = false;
        try {
            Class.forName(driverName);
            connectionQueue = new ArrayBlockingQueue<>(poolSize);
            givenConnections = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionQueue.add(connection);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new TourConnectionPoolException(e);
        }
    }

    public Connection getConnection() throws TourConnectionPoolException {
        Connection connection;
        if(this.isBlocked){
            return null;
        }
        try {
            connection = connectionQueue.take();
            givenConnections.add(connection);
        } catch (InterruptedException e) {
            throw new TourConnectionPoolException(e);
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        givenConnections.remove(connection);
        connectionQueue.add(connection);
    }

    /*private static TourConnectionPool INSTANCE = new TourConnectionPool();
    private static DataSource datasource;

    private TourConnectionPool() {
    }

    public static TourConnectionPool getInstance() {
        return INSTANCE;
    }

    public static synchronized DataSource getConnection() throws DBconnectionException {
        if (datasource == null) {
            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                datasource = (DataSource) envCtx.lookup("jdbc/tour");
            } catch (NamingException ex) {
                throw new DBconnectionException();
            }
        }
        return datasource;
    }*/

}

package model.logic.dal.db_connection;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public final class DBConstantContainer {

    //DB properties
    public static final String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/tour?useTimezone=true&serverTimezone=UTC";

    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "root";

    public static final int MAX_CONNECTIONS = 10;

    //DB constants
    public static final int WRONG_RESPONSE = -1;
    public static final String ID_USER = "iduser";
    public static final String USER_TOUR = "user_tour";
}

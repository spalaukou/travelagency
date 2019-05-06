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
    public static final String ID_USER = "iduser";
    public static final String USER_TYPE = "user.type";
    public static final String USER_LOGIN = "user.login";
    public static final String USER_PASSWORD = "user.password";
    public static final String USER_BALANCE = "user.balance";
    public static final String USER_DISCOUNT = "user.discount";

    public static final String TOUR_ID_TOUR = "tour.idtour";
    public static final String TOUR_NAME = "tour.name";
    public static final String TOUR_HOTEL_ID = "tour.hotel_id";
    public static final String TOUR_NIGHT = "tour.night";
    public static final String TOUR_TRANSPORT_ID = "tour.transport_id";
    public static final String TOUR_COST = "tour.cost";
    public static final String TOUR_HOT = "tour.hot";

    public static final String HOTEL_ID_HOTEL = "hotel.idhotel";
    public static final String HOTEL_NAME = "hotel.name";
    public static final String HOTEL_COUNTRY = "hotel.country";
    public static final String HOTEL_CITY = "hotel.city";
    public static final String HOTEL_STAR = "hotel.star";
    public static final String HOTEL_MEAL = "hotel.meal";
    public static final String HOTEL_PERSON = "hotel.person";

    public static final String TRANSPORT_ID_TRANSPORT = "transport.idtransport";
    public static final String TRANSPORT_TYPE = "transport.type";

}

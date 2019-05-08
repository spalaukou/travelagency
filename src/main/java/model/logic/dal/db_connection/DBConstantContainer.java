package model.logic.dal.db_connection;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public final class DBConstantContainer {

    //DB properties
    public static final String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/tour?useTimezone=true&serverTimezone=UTC";
    public static final String DATABASE_LOGIN = "root";
    public static final String DATABASE_PASSWORD = "root";
    public static final int CONNECTIONS_COUNT = 10;

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

    public static final String ORDER_ID_ORDER = "order.idorder";
    public static final String ORDER_TOTAL_PRICE = "order.totalPrice";

    public static final String HOTEL_ID_HOTEL = "hotel.idhotel";
    public static final String HOTEL_NAME = "hotel.name";
    public static final String HOTEL_COUNTRY = "hotel.country";
    public static final String HOTEL_CITY = "hotel.city";
    public static final String HOTEL_STAR = "hotel.star";
    public static final String HOTEL_MEAL = "hotel.meal";
    public static final String HOTEL_PERSON = "hotel.person";

    public static final String TRANSPORT_ID_TRANSPORT = "transport.idtransport";
    public static final String TRANSPORT_TYPE = "transport.type";

    public static final int WRONG_USER_ID = 0;
    public static final String WRONG_USER_PASSWORD = "";
    public static final int WRONG_USER_BALANCE = -1;
    public static final int WRONG_USER_DISCOUNT = 0;
    public static final int WRONG_TOUR_PRICE = 0;
    public static final int WRONG_ALL_ORDERS_COST = 0;

    //discounts
    public static final float DEFAULT_DISCOUNT = 1.0f;
    public static final float LEVEL1_DISCOUNT = 0.95f;
    public static final float LEVEL2_DISCOUNT = 0.9f;
    public static final float LEVEL3_DISCOUNT = 0.8f;

    public static final int LEVEL1_DISCOUNT_BORDER = 1000;
    public static final int LEVEL2_DISCOUNT_BORDER = 2000;
    public static final int LEVEL3_DISCOUNT_BORDER = 5000;

}

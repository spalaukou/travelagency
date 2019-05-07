package model.logic.dal.db_connection;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public final class DBRequestContainer {

    public static final String USER_SIGN_UP_REQUEST = "INSERT INTO `tour`.`user` (`login`, `password`) VALUES (?, ?);";

    public static final String CHECK_LOGIN_REQUEST = "SELECT `iduser` FROM `tour`.`user` WHERE login = ?";

    public static final String GET_ALL_TOURS_REQUEST = "SELECT *\n" +
            "FROM tour inner join hotel inner join transport\n" +
            "WHERE idhotel = hotel_id AND idtransport = transport_id;";

    public static final String GET_TOURS_BY_COUNTRY_REQUEST = "SELECT *\n" +
            "FROM tour inner join hotel inner join transport\n" +
            "WHERE idhotel = hotel_id AND idtransport = transport_id AND country LIKE ?;";

    public static final String GET_USER_REQUEST = "SELECT * FROM user WHERE login = ?";

    public static final String GET_PASSWORD_REQUEST = "SELECT user.password " +
            "FROM user " +
            "WHERE user.login = ?";

    public static final String GET_USER_BALANCE_REQUEST = "SELECT balance\n" +
            "FROM tour.user\n" +
            "WHERE login = ?";

    public static final String GET_TOUR_COST_HOT_REQUEST = "SELECT cost, hot\n" +
            "FROM tour\n" +
            "WHERE idtour = ?;";

    public static final String CREATE_ORDER_REQUEST = "INSERT INTO `tour`.`order` (`customer_id`, `tour_id`, `totalPrice`) VALUES (?, ?, ?);";

    public static final String GET_ORDERS_BY_ID_REQUEST = "SELECT *\n" +
            "FROM tour.order inner join tour.user inner join tour.tour inner join tour.hotel inner join tour.transport\n" +
            "WHERE customer_id = ? AND customer_id = iduser AND tour_id = idtour AND hotel_id = idhotel AND transport_id = idtransport\n" +
            "ORDER BY idorder ASC;";

    public static final String SET_BALANCE_REQUEST = "UPDATE `tour`.`user` SET `balance` = ? WHERE (`iduser` = ?);";

    public static final String SET_DISCOUNT_REQUEST = "UPDATE `tour`.`user` SET `discount` = ? WHERE (`iduser` = ?);";

    public static final String GET_ALL_ORDERS_COST = "SELECT tour.order.totalPrice\n" +
            "FROM tour.order\n" +
            "WHERE customer_id = ?;";

    public static final String GET_USER_DISCOUNT_REQUEST = "SELECT user.discount\n" +
            "FROM tour.user\n" +
            "WHERE iduser = ?;";
}

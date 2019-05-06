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
            "WHERE  idhotel = hotel_id AND idtransport = transport_id;";

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
}

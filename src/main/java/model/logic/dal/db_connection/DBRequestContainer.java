package model.logic.dal.db_connection;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public final class DBRequestContainer {

    public static final String USER_SIGN_UP_REQUEST = "INSERT INTO `tour`.`user` (`login`, `password`) VALUES (?, ?);";

    public static final String CHECK_LOGIN_REQUEST = "SELECT `iduser` FROM `tour`.`user` WHERE login = ?";

    public static final String GET_ALL_TOURS = "SELECT " +
            "hotel.country, hotel.city, hotel.name, hotel.star, hotel.meal, hotel.person, " +
            "tour.night, transport.type, tour.cost, tour.hot " +
            "FROM tour, hotel, transport " +
            "WHERE idhotel = hotel_id AND idtransport = transport_id; ";

    public static final String GET_ALL_TOURS_REQUEST = "SELECT " +
            "hotel.country, hotel.city, hotel.name, hotel.star, hotel.meal, hotel.person, " +
            "tour.night, transport.type, tour.cost, tour.hot " +
            "FROM tour, hotel, transport " +
            "WHERE idhotel = hotel_id AND idtransport = transport_id; ";

    public static final String GET_TOURS_BY_COUNTRY_REQUEST = "SELECT " +
            "hotel.country, hotel.city, hotel.name, hotel.star, hotel.meal, hotel.person, " +
            "tour.night, transport.type, tour.cost, tour.hot " +
            "FROM tour, hotel, transport " +
            "WHERE idhotel = hotel_id AND idtransport = transport_id; ";

    public static final String GET_USER_REQUEST = "SELECT * FROM user WHERE login = ?";

    public static final String GET_PASSWORD_REQUEST = "SELECT user.password " +
            "FROM user " +
            "WHERE user.login = ?";
}

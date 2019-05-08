package model.logic.dal.db_connection;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public final class DBRequestContainer {

    public static final String USER_SIGN_UP_REQUEST = "INSERT\n" +
            "INTO `tour`.`user` (`login`, `password`)\n" +
            "VALUES (?, ?);";

    public static final String CHECK_LOGIN_REQUEST = "SELECT\n" +
            "`iduser`\n" +
            "FROM `tour`.`user`\n" +
            "WHERE `user`.`login` = ?";

    //    public static final String GET_ALL_TOURS_REQUEST = "SELECT *\n" +
//            "FROM tour inner join hotel inner join transport\n" +
//            "WHERE idhotel = hotel_id AND idtransport = transport_id;";
    public static final String GET_ALL_TOURS_REQUEST = "SELECT\n" +
            "`tour`.`idtour`, `tour`.`name`, `tour`.`hotel_id`, `tour`.`night`, `tour`.`transport_id`, `tour`.`cost`, `tour`.`hot`,\n" +
            "`hotel`.`idhotel`, `hotel`.`name`, `hotel`.`country`, `hotel`.`city`, `hotel`.`star`, `hotel`.`meal`, `hotel`.`person`,\n" +
            "`transport`.`idtransport`, `transport`.`type`\n" +
            "FROM `tour`.`tour` inner join `tour`.`hotel` inner join `tour`.`transport`\n" +
            "WHERE `hotel`.`idhotel` = `tour`.`hotel_id`\n" +
            "AND `transport`.`idtransport` = `tour`.`transport_id`;";

    //    public static final String GET_TOURS_BY_COUNTRY_REQUEST = "SELECT *\n" +
//            "FROM tour inner join hotel inner join transport\n" +
//            "WHERE idhotel = hotel_id AND idtransport = transport_id AND country LIKE ?;";
    public static final String GET_TOURS_BY_COUNTRY_REQUEST = "SELECT\n" +
            "`tour`.`idtour`, `tour`.`name`, `tour`.`hotel_id`, `tour`.`night`, `tour`.`transport_id`, `tour`.`cost`, `tour`.`hot`,\n" +
            "`hotel`.`idhotel`, `hotel`.`name`, `hotel`.`country`, `hotel`.`city`, `hotel`.`star`, `hotel`.`meal`, `hotel`.`person`,\n" +
            "`transport`.`idtransport`, `transport`.`type`\n" +
            "FROM `tour`.`tour` inner join `tour`.`hotel` inner join `tour`.`transport`\n" +
            "WHERE `hotel`.`idhotel` = `tour`.`hotel_id`\n" +
            "AND `transport`.`idtransport` = `tour`.`transport_id`\n" +
            "AND `hotel`.`country` LIKE ?;";

    public static final String GET_USER_REQUEST = "SELECT\n" +
            "`user`.`iduser`, `user`.`type`, `user`.`login`, `user`.`password`, `user`.`balance`, `user`.`discount`\n" +
            "FROM `tour`.`user`\n" +
            "WHERE `user`.`login` = ?;";

    public static final String GET_PASSWORD_REQUEST = "SELECT\n" +
            "`user`.`password`\n" +
            "FROM `tour`.`user`\n" +
            "WHERE `user`.`login` = ?";

    public static final String GET_USER_BALANCE_REQUEST = "SELECT balance\n" +
            "FROM tour.user\n" +
            "WHERE login = ?";

    public static final String GET_TOUR_COST_HOT_REQUEST = "SELECT\n" +
            "`tour`.`cost`, `tour`.`hot`\n" +
            "FROM `tour`.`tour`\n" +
            "WHERE `tour`.`idtour` = ?;";

    public static final String CREATE_ORDER_REQUEST = "INSERT\n" +
            "INTO `tour`.`order` (`customer_id`, `tour_id`, `totalPrice`)\n" +
            "VALUES (?, ?, ?);";

//    public static final String GET_ORDERS_BY_ID_REQUEST = "SELECT *\n" +
//            "FROM tour.order inner join tour.user inner join tour.tour inner join tour.hotel inner join tour.transport\n" +
//            "WHERE customer_id = ? AND customer_id = iduser AND tour_id = idtour AND hotel_id = idhotel AND transport_id = idtransport\n" +
//            "ORDER BY idorder ASC;";
    public static final String GET_ORDERS_BY_ID_REQUEST = "SELECT\n" +
        "`order`.`idorder`, `order`.`customer_id`,  `order`.`tour_id`, `order`.`totalPrice`,\n" +
        "`user`.`iduser`, `user`.`type`, `user`.`login`, `user`.`password`, `user`.`balance`, `user`.`discount`,\n" +
        "`tour`.`idtour`, `tour`.`name`, `tour`.`hotel_id`, `tour`.`night`, `tour`.`transport_id`, `tour`.`cost`, `tour`.`hot`,\n" +
        "`hotel`.`idhotel`, `hotel`.`name`, `hotel`.`country`, `hotel`.`city`, `hotel`.`star`, `hotel`.`meal`, `hotel`.`person`,\n" +
        "`transport`.`idtransport`, `transport`.`type`\n" +
        "FROM `tour`.`order` inner join `tour`.`user` inner join `tour`.`tour` inner join `tour`.`hotel` inner join `tour`.`transport`\n" +
        "WHERE `order`.`customer_id` = ?\n" +
        "AND `order`.`customer_id` = `user`.`iduser`\n" +
        "AND `order`.`tour_id` = `tour`.`idtour`\n" +
        "AND `tour`.`hotel_id` = `hotel`.`idhotel`\n" +
        "AND `tour`.`transport_id` = `transport`.`idtransport`\n" +
        "ORDER BY `order`.`idorder` ASC;";

    public static final String SET_BALANCE_REQUEST = "UPDATE\n" +
            "`tour`.`user`\n" +
            "SET `balance` = ?\n" +
            "WHERE (`iduser` = ?);";

    public static final String SET_DISCOUNT_REQUEST = "UPDATE\n" +
            "`tour`.`user`\n" +
            "SET `discount` = ?\n" +
            "WHERE (`iduser` = ?);";

    public static final String GET_ALL_ORDERS_COST = "SELECT\n" +
            "`tour`.`order`.`totalPrice`\n" +
            "FROM `tour`.`order`\n" +
            "WHERE `order`.`customer_id` = ?;";

    public static final String GET_USER_DISCOUNT_REQUEST = "SELECT\n" +
            "`user`.`discount`\n" +
            "FROM `tour`.`user`\n" +
            "WHERE `user`.`iduser` = ?;";

    public static final String CANCEL_ORDER_REQUEST = "DELETE\n" +
            "FROM `tour`.`order`\n" +
            "WHERE (`idorder` = ?);";
}

package model;

/**
 * @author Stanislau Palaukou on 25.04.2019
 * @project TravelAgency
 */

public final class ConstantContainer {

    //command
    public static final String COMMAND = "command";

    //parameters
    public static final String LOGIN = "login";
    public static final int LOGIN_MIN_LENGTH = 3;
    public static final String PASSWORD = "password";
    public static final int PASSWORD_MIN_LENGTH = 3;
    public static final String USER = "user";
    public static final String COUNTRY = "country";
    public static final String LOCALIZATION = "localization";
    public static final String TOUR_ID = "tour_id";
    public static final String PARAM = "param";
    public static final String ALL = "all";
    public static final float DEFAULT_DISCOUNT = 1.0f;
    public static final int WRONG_BALANCE = -1;
    public static final int WRONG_DISCOUNT = -1;
    public static final int WRONG_PRICE = 0;
    public static final String TOTAL_PRICE = "tp";
    public static final String TOUR_TYPE = "tourType";
    public static final String HOTEL_ID = "hotelID";
    public static final String HOTEL_COUNTRY = "hotelCountry";
    public static final String HOTEL_CITY = "hotelCity";
    public static final String HOTEL_NAME = "hotelName";
    public static final String HOTEL_STAR = "hotelStar";
    public static final String HOTEL_MEAL = "hotelMeal";
    public static final String HOTEL_PERSON = "hotelPerson";
    public static final String TOUR_NIGHT = "tourNight";
    public static final String TRANSPORT_TYPE = "transport";
    public static final String TOUR_COST = "tourCost";
    public static final String TOUR_HOT = "tourHot";

    //attributes
    public static final String ERR_LOGIN_PASS_MSG = "errorLoginPassMessage";
    public static final String SHORT_LOGIN_PASS_MSG = "shortLoginPassMessage";
    public static final String ERR_NOT_ENOUGH_MONEY_MSG = "errorNotEnoughMoneyMessage";
    public static final String AFTER_PURCHASE_MSG = "afterPurchaseMessage";
    public static final String AFTER_CANCEL_MSG = "afterCancelMessage";
    public static final String AFTER_ADD_TOUR_MSG = "afterAddMessage";
    public static final String ERR_ADD_TOUR_MSG = "errorAddMessage";
    public static final String ERR_UPDATE_TOUR_MSG = "errorUpdateMessage";
    public static final String AFTER_UPDATE_TOUR_MSG = "afterUpdateMessage";
    public static final String USER_ID = "userid";
    public static final String ID = "id";
    public static final String USER_TYPE = "userType";
    public static final String BALANCE = "balance";
    public static final String DISCOUNT = "discount";
    public static final String TOURS = "tours";
    public static final String ORDERS = "orders";
    public static final String AGENT = "AGENT";

    //pages
    public static final String INDEX_PAGE = "index.jsp";
    public static final String SIGN_UP_PAGE = "jsp/SignUp.jsp";
    public static final String SIGN_UP_RESULT_PAGE = "jsp/SignUpResult.jsp";
    public static final String SIGN_IN_PAGE = "jsp/SignIn.jsp";
    public static final String TOURS_PAGE = "jsp/ToursTable.jsp";
    public static final String MANAGE_TOURS_PAGE = "jsp/ManageToursTable.jsp";
    public static final String ORDERS_PAGE = "jsp/OrdersTable.jsp";
    public static final String MY_ORDERS_PAGE = "/start?command=show_orders";
    public static final String ERROR_PAGE = "jsp/Error.jsp";
    public static final String SHOW_MANAGE_TOURS_PAGE = "start?command=show_tours&param=manage";

    //messages
    public static final String MESSAGE_LOGIN_ERROR = "Incorrect login or password.";
    public static final String MESSAGE_USER_EXISTS = "This user already exists. Enter another login, please.";
    public static final String MESSAGE_SHORT_LOGIN_PASS = "Too short login or password (min 3).";
    public static final String MESSAGE_NULL_PAGE = "Page not found. Business logic error";
    public static final String MESSAGE_WRONG_ACTION = ": command not found or wrong!";
    public static final String MESSAGE_NOT_ENOUGH_MONEY_ERROR = "Sorry, you have not enough money to buy this tour! Please, select another one or fund your account.";
    public static final String MESSAGE_AFTER_PURCHASE = "Thank you for your purchase!";
    public static final String MESSAGE_AFTER_CANCEL = "Your order has been cancelled!";
    public static final String MESSAGE_AFTER_ADD_TOUR = "New tour has been added successfully!";
    public static final String MESSAGE_AFTER_UPDATE_TOUR = "Tour has been updated successfully!";
    public static final String MESSAGE_ERR_ADD_TOUR = "Please enter valid data in all columns above!";
    public static final String MESSAGE_ERR_UPDATE_TOUR = "Please enter valid data!";

    //logger messages
    public static final String DATA_SOURCE_ERR_MSG = "Data source error.";
    public static final String SQL_ERR_MSG = "SQL error.";
    public static final String CONNECTION_POOL_ERR_MSG = "TourConnectionPool initialization error.";
    public static final String IO_ERR_MSG = "I/O error.";
    public static final String SERVLET_ERR_MSG = "Agency Servlet error.";

}

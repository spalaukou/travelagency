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
    public static final float LEVEL1_DISCOUNT = 0.95f;
    public static final float LEVEL2_DISCOUNT = 0.9f;
    public static final float LEVEL3_DISCOUNT = 0.8f;
    public static final int WRONG_BALANCE = -1;
    public static final int WRONG_PRICE = 0;
    public static final String TOTAL_PRICE = "tp";

    //attributes
    public static final String ERR_LOGIN_PASS_MSG = "errorLoginPassMessage";
    public static final String ERR_NOT_ENOUGH_MONEY_MSG = "errorNotEnoughMoneyMessage";
    public static final String AFTER_PURCHASE_MSG = "afterPurchaseMessage";
    public static final String USER_ID = "userid";
    public static final String USER_TYPE = "userType";
    public static final String BALANCE = "balance";
    public static final String DISCOUNT = "discount";
    public static final String TOURS = "tours";
    public static final String ORDERS = "orders";

    //pages
    public static final String GUEST_HEADER = "header/guestHeader.jsp";
    public static final String INDEX_PAGE = "index.jsp";
    public static final String SIGN_UP_PAGE = "jsp/sign_up.jsp";
    public static final String SIGN_UP_RESULT_PAGE = "jsp/sign_up_result.jsp";
    public static final String SIGN_IN_PAGE = "jsp/sign_in.jsp";
    public static final String TOURS_PAGE = "jsp/tours_table.jsp";
    public static final String ORDERS_PAGE = "jsp/orders_table.jsp";
    public static final String MY_ORDERS_PAGE = "/start?command=show_orders";
    public static final String MAIN_PAGE = "jsp/main.jsp";
    public static final String ERROR_PAGE = "jsp/error.jsp";

    //messages
    public static final String MESSAGE_LOGIN_ERROR = "Incorrect login or password.";
    public static final String MESSAGE_USER_EXISTS = "This user already exists. Enter another login, please.";
    public static final String MESSAGE_SHORT_LOGIN_PASS = "Too short login or password (min 3).";
    public static final String MESSAGE_NULL_PAGE = "Page not found. Business logic error";
    public static final String MESSAGE_WRONG_ACTION = ": command not found or wrong!";
    public static final String MESSAGE_NOT_ENOUGH_MONEY_ERROR = "Sorry, you have not enough money to buy this tour! Please, select another one or fund your account.";
    public static final String MESSAGE_AFTER_PURCHASE = "Thank you for your purchase!";

}

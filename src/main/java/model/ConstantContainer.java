package model;

/**
 * @author Stanislau Palaukou on 25.04.2019
 * @project TravelAgency
 */

public final class ConstantContainer {
    //command
    public final static String COMMAND = "command";

    //parameters
    public final static String LOGIN = "login";
    public final static int LOGIN_MIN_LENGTH = 3;
    public final static String PASSWORD = "password";
    public final static int PASSWORD_MIN_LENGTH = 3;
    public final static String USER = "user";
    public final static String SHOW_ALL_TOURS = "show_all_tours";

    //attributes
    public final static String ERR_LOGIN_PASS_MSG = "errorLoginPassMessage";
    public final static String USER_ID = "userid";
    public final static String USER_TYPE = "userType";
    public final static String BALANCE = "balance";
    public final static String DISCOUNT = "discount";

    //pages
    public final static String GUEST_HEADER = "header/GuestHeader.jsp";
    public final static String INDEX_PAGE = "index.jsp";
    public final static String SIGN_UP_PAGE = "jsp/sign_up.jsp";
    public final static String SIGN_UP_RESULT_PAGE = "jsp/sign_up_result.jsp";
    public final static String SIGN_IN_PAGE = "jsp/sign_in.jsp";
    public final static String TOURS_PAGE = "jsp/tours_table.jsp";
    public final static String MAIN_PAGE = "jsp/main.jsp";
    public final static String ERROR_PAGE = "jsp/error.jsp";

    //messages
    public final static String MESSAGE_LOGIN_ERROR = "Incorrect login or password.";
    public final static String MESSAGE_USER_EXISTS = "This user already exists. Enter another login, please.";
    public final static String MESSAGE_SHORT_LOGIN_PASS = "Too short login or password (min 3).";
    public final static String MESSAGE_NULL_PAGE = "Page not found. Business logic error";
    public final static String MESSAGE_WRONG_ACTION = ": command not found or wrong!";
}

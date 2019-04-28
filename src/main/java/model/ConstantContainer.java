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

    //pages
    public final static String SIGN_UP_PAGE = "jsp/sign_up.jsp";
    public final static String TOURS_PAGE = "jsp/tours_table.jsp";
}

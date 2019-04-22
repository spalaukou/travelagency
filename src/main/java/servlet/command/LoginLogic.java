package servlet.command;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "admin";

    public static boolean checkLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }

}
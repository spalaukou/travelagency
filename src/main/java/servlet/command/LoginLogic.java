package servlet.command;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class LoginLogic {
    private final static String MODERATOR_LOGIN = "anna";
    private final static String MODERATOR_PASS = "anna";

    public static boolean checkLogin(String enterLogin, String enterPass) {
        return MODERATOR_LOGIN.equals(enterLogin) && MODERATOR_PASS.equals(enterPass);
    }

}
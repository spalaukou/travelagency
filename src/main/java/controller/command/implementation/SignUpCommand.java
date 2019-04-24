package controller.command.implementation;

import controller.command.Command;
import model.logic.service.UserService;
import model.logic.service.implementation.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class SignUpCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        userService.signUp(login, password);


        return null;
    }
}

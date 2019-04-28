package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import servlet.command.ConfigurationManager;
import servlet.command.LoginLogic;
import servlet.command.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из запроса логина и пароля
        String login = request.getParameter(ConstantContainer.LOGIN);
        String pass = request.getParameter(ConstantContainer.PASSWORD);
        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute(ConstantContainer.USER, login);
            // определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
                    request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}

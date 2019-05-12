package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

/**
 * The Command changes Locale for the user.
 *
 * @author Stanislau Palaukou on 02.05.2019
 * @project TravelAgency
 */

public class ChangeLocaleCommand implements Command {

    /**
     * Gets a new localization parameter from request and sets it
     * to the user session.
     *
     * @param request
     * @return the index page for the user.
     */
    @Override
    public String execute(HttpServletRequest request) {

        String newLocalization = request.getParameter(ConstantContainer.LOCALIZATION);

        request.getSession().setAttribute(ConstantContainer.LOCALIZATION, newLocalization);

        Config.set(request.getSession(), Config.FMT_LOCALE, newLocalization);

        return ConstantContainer.INDEX_PAGE;
    }
}

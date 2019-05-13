package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * User logout command.
 *
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class SignOutCommand implements Command {

    /**
     * Invalidates user's session.
     *
     * @param request
     * @return the index page of application.
     */
    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().invalidate();

        return ConstantContainer.INDEX_PAGE;
    }
}

package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * The Empty Command works when the called Command is not found or does not exists.
 *
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class EmptyCommand implements Command {

    /**
     * Simple returning a page.
     *
     * @param request
     * @return error page for user.
     */
    @Override
    public String execute(HttpServletRequest request) {

        return ConstantContainer.ERROR_PAGE;
    }
}

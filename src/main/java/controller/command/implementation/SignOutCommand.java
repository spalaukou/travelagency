package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class SignOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().invalidate();

        return ConstantContainer.INDEX_PAGE;
    }
}

package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public class EmptyCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ConstantContainer.ERROR_PAGE;
    }
}

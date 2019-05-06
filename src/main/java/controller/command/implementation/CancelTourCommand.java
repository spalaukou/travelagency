package controller.command.implementation;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class CancelTourCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}

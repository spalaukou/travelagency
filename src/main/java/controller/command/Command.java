package controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface Command {
    String execute(HttpServletRequest request);
}

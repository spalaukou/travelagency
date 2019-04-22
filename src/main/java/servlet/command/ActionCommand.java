package servlet.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public interface ActionCommand {
    String execute(HttpServletRequest request);
}

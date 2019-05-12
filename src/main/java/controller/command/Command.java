package controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The basic interface for all commands that exist.
 * Defines one method for all commands - execute.
 *
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

public interface Command {

    String execute(HttpServletRequest request);

}

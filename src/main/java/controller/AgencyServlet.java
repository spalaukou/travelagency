package controller;

import controller.command.Command;
import controller.command.CommandManager;
import model.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The main application servlet that handles everything.
 *
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

@WebServlet("/start")
public class AgencyServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AgencyServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
    }

    /**
     * The main method that processes the request, passes it to the Command,
     * and then passes the returned page to the dispatcher.
     *
     * @param request
     * @param response
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String cmd = request.getParameter(ConstantContainer.COMMAND);
        Command command = CommandManager.getCommand(cmd);

        String page = command.execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        try {

            dispatcher.forward(request, response);

        } catch (ServletException e) {
            LOGGER.error(ConstantContainer.SERVLET_ERR_MSG, e);
        } catch (IOException e) {
            LOGGER.error(ConstantContainer.IO_ERR_MSG, e);
        }
    }
}

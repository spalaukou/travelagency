package controller;

import controller.command.Command;
import controller.command.CommandManager;
import model.ConstantContainer;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.DBconnectionException;
import model.logic.exception.technical.TourConnectionPoolException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Stanislau Palaukou on 24.04.2019
 * @project TravelAgency
 */

@WebServlet("/start")
public class AgencyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) {

        String cmd = request.getParameter(ConstantContainer.COMMAND);

        Command command = CommandManager.getCommand(cmd);

        String page;
        page = command.execute(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

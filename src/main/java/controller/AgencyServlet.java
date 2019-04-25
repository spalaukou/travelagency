package controller;

import controller.command.Command;
import controller.command.CommandManager;
import model.logic.ConstantContainer;
import model.logic.exception.technical.DBconnectionException;

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

@WebServlet(name = "mainController")
public class AgencyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (DBconnectionException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DBconnectionException e) {
            e.printStackTrace();
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DBconnectionException {

        String cmd = request.getParameter(ConstantContainer.COMMAND);

        Command command  = CommandManager.getCommand(cmd);
        String page = command.execute(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
}

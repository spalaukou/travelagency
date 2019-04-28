package controller.command.implementation;

import controller.command.Command;
import model.logic.Calculator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class CalculateCommand implements Command {
    private Calculator calculator = new Calculator();

    @Override
    public String execute(HttpServletRequest request) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));

        int result = calculator.sum(a, b);

        request.setAttribute("result", result);

        return "/jsp/calculator_result.jsp";
    }
}

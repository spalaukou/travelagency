package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.logic.service.OrderService;
import model.logic.service.ServiceFactory;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class BuyTourCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConstantContainer.SIGN_IN_PAGE;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderService orderService = serviceFactory.getOrderService();

        String login = (String) request.getSession().getAttribute(ConstantContainer.LOGIN);

        if (login != null) {
            ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
            Validator balanceValidator = validatorFactory.getBalanceValidator();
            if (balanceValidator.validate(request)) {
                String tourID = request.getParameter(ConstantContainer.TOUR_ID);

                orderService.createOrder(login, tourID);

                page = ConstantContainer.ORDERS_PAGE;
            } else {
                //not enough money message
            }
        }

        return page;
    }
}

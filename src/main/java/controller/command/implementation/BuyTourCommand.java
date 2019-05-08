package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.logic.exception.technical.DAOSQLException;
import model.logic.exception.technical.TourConnectionPoolException;
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

                String userID = request.getSession().getAttribute(ConstantContainer.USER_ID).toString();
                String tourID = request.getParameter(ConstantContainer.TOUR_ID);
                int totalPrice = Integer.parseInt(request.getParameter(ConstantContainer.TOTAL_PRICE));
                int balance = (int) request.getSession().getAttribute(ConstantContainer.BALANCE);

                try {

                    float newDiscount = orderService.createOrder(userID, tourID, totalPrice, balance);
                    request.getSession().setAttribute(ConstantContainer.BALANCE, (balance - totalPrice));

                    if(newDiscount != ConstantContainer.WRONG_DISCOUNT) {
                        request.getSession().setAttribute(ConstantContainer.DISCOUNT, newDiscount);
                    }

                    request.setAttribute(ConstantContainer.AFTER_PURCHASE_MSG, ConstantContainer.MESSAGE_AFTER_PURCHASE);
                    page = ConstantContainer.MY_ORDERS_PAGE;
                } catch (TourConnectionPoolException e) {
                    e.printStackTrace();
                } catch (DAOSQLException e) {
                    e.printStackTrace();
                }

            } else {
                request.setAttribute(ConstantContainer.ERR_NOT_ENOUGH_MONEY_MSG, ConstantContainer.MESSAGE_NOT_ENOUGH_MONEY_ERROR);
                page = ConstantContainer.INDEX_PAGE;
                //not enough money message
            }
        }

        return page;
    }
}

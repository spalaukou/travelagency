package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.service.OrderService;
import model.logic.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class CancelTourCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(CancelTourCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConstantContainer.SIGN_IN_PAGE;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderService orderService = serviceFactory.getOrderService();

        String login = (String) request.getSession().getAttribute(ConstantContainer.LOGIN);

        if (login != null) {
            String userID = request.getSession().getAttribute(ConstantContainer.USER_ID).toString();
            String orderID = request.getParameter(ConstantContainer.ID);
            int totalPrice = Integer.parseInt(request.getParameter(ConstantContainer.TOTAL_PRICE));
            int balance = (int) request.getSession().getAttribute(ConstantContainer.BALANCE);

            try {

                float newDiscount = orderService.cancelOrder(userID, orderID, totalPrice, balance);
                request.getSession().setAttribute(ConstantContainer.BALANCE, (balance + totalPrice));

                if (newDiscount != ConstantContainer.WRONG_DISCOUNT) {
                    request.getSession().setAttribute(ConstantContainer.DISCOUNT, newDiscount);
                }

                request.setAttribute(ConstantContainer.AFTER_CANCEL_MSG, ConstantContainer.MESSAGE_AFTER_CANCEL);
                page = ConstantContainer.MY_ORDERS_PAGE;
            } catch (DataSourceException e) {
                LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
            } catch (ServiceSQLException e) {
                LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
            }
        }

        return page;
    }
}

package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.service.OrderService;
import model.logic.service.ServiceFactory;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The Command makes the purchase of the tour by the customer from his account.
 *
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class BuyTourCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(BuyTourCommand.class);

    /**
     * Creates a new order, checking the conditions for this.
     *
     * @param request
     * @return the user’s orders page. If the conditions are not met, the initial page with
     * informational message is returned. If the user is not signed in, the sign in page is
     * returned.
     */
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
                    request.removeAttribute(ConstantContainer.TOUR_ID);
                    page = ConstantContainer.MY_ORDERS_PAGE;

                } catch (DataSourceException e) {
                    LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
                } catch (ServiceSQLException e) {
                    LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
                }

            } else {
                request.setAttribute(ConstantContainer.ERR_NOT_ENOUGH_MONEY_MSG, ConstantContainer.MESSAGE_NOT_ENOUGH_MONEY_ERROR);
                page = ConstantContainer.INDEX_PAGE;
            }
        }

        return page;
    }
}

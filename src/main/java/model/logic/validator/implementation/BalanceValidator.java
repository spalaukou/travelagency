package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.TourService;
import model.logic.service.UserService;
import model.logic.validator.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The validator checks if there is enough money
 * in the user's account to purchase the tour.
 *
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class BalanceValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(BalanceValidator.class);

    /**
     * Checks if there is enough money in the user's account to purchase the tour.
     * Compares the money in the account with the final cost of the tour.
     *
     * @param request
     * @return true if there is enough money for purchase.
     */
    @Override
    public boolean validate(HttpServletRequest request) {
        String tourID = request.getParameter(ConstantContainer.TOUR_ID);
        String login = (String) request.getSession().getAttribute(ConstantContainer.LOGIN);
        float discount = (float) request.getSession().getAttribute(ConstantContainer.DISCOUNT);
        int tp = Integer.parseInt(request.getParameter(ConstantContainer.TOTAL_PRICE));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        TourService tourService = serviceFactory.getTourService();

        try {
            int balance = userService.getBalance(login);
            int price = tourService.getPrice(tourID);

            int totalPrice = (int) (price * discount);

            if (totalPrice <= balance && totalPrice == tp) {
                return true;
            }
        } catch (DataSourceException e) {
            LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
        } catch (ServiceSQLException e) {
            LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
        }
        return false;
    }
}

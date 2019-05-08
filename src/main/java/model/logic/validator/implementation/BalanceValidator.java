package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.TourService;
import model.logic.service.UserService;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class BalanceValidator implements Validator {

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
            //log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            //log.error("SQL error", e);
        }
        return false;
    }
}

package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.exception.logical.DataSourceException;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.service.OrderService;
import model.logic.service.ServiceFactory;
import model.logic.validator.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The validator is responsible for the presence of the requested order in the system.
 *
 * @author Stanislau Palaukou on 10.05.2019
 * @project TravelAgency
 */

public class OrderExistsValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(OrderExistsValidator.class);

    /**
     * Checks if the requested Order exists in the system.
     *
     * @param request
     * @return true if the Order exists in the system.
     */
    @Override
    public boolean validate(HttpServletRequest request) {
        String orderID = request.getParameter(ConstantContainer.ID);

        if(orderID != null) {
            int ID = Integer.parseInt(orderID);

            try {

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                OrderService orderService = serviceFactory.getOrderService();
                int expectedID = orderService.getID(orderID);

                if (expectedID == ID) {
                    return true;
                }

            } catch (
                    DataSourceException e) {
                LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
            } catch (
                    ServiceSQLException e) {
                LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
            }
        }

        return false;
    }
}

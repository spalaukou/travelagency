package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.Order;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.service.OrderService;
import model.logic.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class ShowOrdersCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(ShowOrdersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        List<Order> orders = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderService orderService = serviceFactory.getOrderService();

        String userID = request.getSession().getAttribute(ConstantContainer.USER_ID).toString();
        String param = request.getParameter(ConstantContainer.PARAM);

        try {

            if (ConstantContainer.ALL.equals(param)) {
                //orders = orderService.getAllOrders();
            } else {
                orders = orderService.getOrdersByID(userID);
            }

            request.setAttribute(ConstantContainer.ORDERS, orders);

        } catch (DataSourceException e) {
            LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
        } catch (ServiceSQLException e) {
            LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
        }

        return ConstantContainer.ORDERS_PAGE;
    }
}

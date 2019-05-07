package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.Order;
import model.logic.service.OrderService;
import model.logic.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Stanislau Palaukou on 06.05.2019
 * @project TravelAgency
 */

public class ShowOrdersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        List<Order> orders = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderService orderService = serviceFactory.getOrderService();

        String userID = request.getSession().getAttribute(ConstantContainer.USER_ID).toString();
        String param = request.getParameter(ConstantContainer.PARAM);

        if(ConstantContainer.ALL.equals(param)) {
            //orders = orderService.getAllOrders();
        } else {
            orders = orderService.getOrdersByID(userID);
        }

        request.setAttribute(ConstantContainer.ORDERS, orders);

        return ConstantContainer.ORDERS_PAGE;
    }
}

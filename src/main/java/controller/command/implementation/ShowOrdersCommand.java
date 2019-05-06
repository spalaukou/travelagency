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
        List<Order> orders;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderService orderService = serviceFactory.getOrderService();


        return ConstantContainer.ORDERS_PAGE;
    }
}

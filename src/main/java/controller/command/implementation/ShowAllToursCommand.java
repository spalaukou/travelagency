package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.UserTour;
import model.logic.dal.db_connection.DBConstantContainer;
import model.logic.service.ServiceFactory;
import model.logic.service.ShowAllToursService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class ShowAllToursCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        List<UserTour> list;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ShowAllToursService tourService = serviceFactory.getShowAllToursService();

        list = tourService.getList();

        request.setAttribute("tourlist", list);

        return ConstantContainer.TOURS_PAGE;
    }
}

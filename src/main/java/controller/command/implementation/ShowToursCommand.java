package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.Tour;
import model.logic.service.ServiceFactory;
import model.logic.service.TourService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public class ShowToursCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        List<Tour> tours;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TourService tourService = serviceFactory.getTourService();

        String country = request.getParameter(ConstantContainer.COUNTRY);

        if(country == null) {
            tours = tourService.getAllTours();
        } else {
            tours = tourService.getToursByCountry(country);
        }

        request.setAttribute(ConstantContainer.TOURS, tours);

        return ConstantContainer.TOURS_PAGE;
    }
}

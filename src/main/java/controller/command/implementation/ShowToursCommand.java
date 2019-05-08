package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.Tour;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
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
        float discount;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TourService tourService = serviceFactory.getTourService();

        if(request.getSession().getAttribute(ConstantContainer.DISCOUNT) != null) {
            discount = (float) request.getSession().getAttribute(ConstantContainer.DISCOUNT);
        } else {
            discount = ConstantContainer.DEFAULT_DISCOUNT;
        }

        try {

            List<Tour> tours;
            String country = request.getParameter(ConstantContainer.COUNTRY);

            if (country == null) {
                tours = tourService.getAllTours(discount);
            } else {
                tours = tourService.getToursByCountry(country, discount);
            }

            request.setAttribute(ConstantContainer.TOURS, tours);

        } catch (DataSourceException e) {
            //log.error("Problems with data source", e);
        } catch (ServiceSQLException e) {
            //log.error("SQL error", e);
        }

        return ConstantContainer.TOURS_PAGE;
    }
}

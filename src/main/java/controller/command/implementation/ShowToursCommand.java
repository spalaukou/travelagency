package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.Tour;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.TourService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Stanislau Palaukou on 03.05.2019
 * @project TravelAgency
 */

public class ShowToursCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(ShowToursCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConstantContainer.TOURS_PAGE;
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

            String manage = request.getParameter(ConstantContainer.PARAM);
            if(manage != null) {
                page = ConstantContainer.MANAGE_TOURS_PAGE;
            }

        } catch (DataSourceException e) {
            LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
        } catch (ServiceSQLException e) {
            LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
        }

        return page;
    }
}

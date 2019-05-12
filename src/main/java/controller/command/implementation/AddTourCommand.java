package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.logic.exception.logical.DataSourceException;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.service.ServiceFactory;
import model.logic.service.TourService;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The Command responsible for adding a new tour by a travel agent.
 *
 * @author Stanislau Palaukou on 10.05.2019
 * @project TravelAgency
 */

public class AddTourCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AddTourCommand.class);

    /**
     * Adds a new tour and shows all existing tours in the tours manage panel.
     *
     * @param request
     * @return manage tours page for Tour Agent user.
     */
    @Override
    public String execute(HttpServletRequest request) {

        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator addTourDataValidator = validatorFactory.getAddTourDataValidator();

        if(addTourDataValidator.validate(request)) {
            String tourType = request.getParameter(ConstantContainer.TOUR_TYPE);
            String hotelID = request.getParameter(ConstantContainer.HOTEL_ID);
            String hotelNight = request.getParameter(ConstantContainer.TOUR_NIGHT);
            String transport = request.getParameter(ConstantContainer.TRANSPORT_TYPE);
            String tourCost = request.getParameter(ConstantContainer.TOUR_COST);
            String tourHot = request.getParameter(ConstantContainer.TOUR_HOT);

            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                TourService tourService = serviceFactory.getTourService();

                tourService.createTour(tourType, hotelID, hotelNight, transport, tourCost, tourHot);

                request.setAttribute(ConstantContainer.AFTER_ADD_TOUR_MSG, ConstantContainer.MESSAGE_AFTER_ADD_TOUR);

            } catch (DataSourceException e) {
                LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
            } catch (ServiceSQLException e) {
                LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
            }
        } else {
            request.setAttribute(ConstantContainer.ERR_ADD_TOUR_MSG, ConstantContainer.MESSAGE_ERR_ADD_TOUR);
        }

        return ConstantContainer.SHOW_MANAGE_TOURS_PAGE;
    }
}

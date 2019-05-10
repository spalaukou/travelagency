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
 * @author Stanislau Palaukou on 10.05.2019
 * @project TravelAgency
 */
public class UpdateTourCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(UpdateTourCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator updateTourDataValidator = validatorFactory.getUpdateTourDataValidator();

        if(updateTourDataValidator.validate(request)) {
            String tourID = request.getParameter(ConstantContainer.TOUR_ID);
            String tourCost = request.getParameter(ConstantContainer.TOUR_COST);
            String tourHot = request.getParameter(ConstantContainer.TOUR_HOT);

            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                TourService tourService = serviceFactory.getTourService();

                tourService.updateTour(tourID, tourCost, tourHot);

                request.setAttribute(ConstantContainer.AFTER_UPDATE_TOUR_MSG, ConstantContainer.MESSAGE_AFTER_UPDATE_TOUR);

            } catch (DataSourceException e) {
                LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
            } catch (ServiceSQLException e) {
                LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
            }
        } else {
            request.setAttribute(ConstantContainer.ERR_UPDATE_TOUR_MSG, ConstantContainer.MESSAGE_ERR_UPDATE_TOUR);
        }

        return ConstantContainer.SHOW_MANAGE_TOURS_PAGE;
    }
}

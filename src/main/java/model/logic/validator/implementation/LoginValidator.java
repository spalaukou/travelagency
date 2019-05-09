package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;
import model.logic.validator.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class LoginValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(LoginValidator.class);

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            int userID = userService.getID(login);
            return userID <= 0;
        } catch (DataSourceException e) {
            LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
        } catch (ServiceSQLException e) {
            LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
        }

        return false;
    }
}

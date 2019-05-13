package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;
import model.logic.validator.Validator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The validator is responsible for matching the login and password
 * to provide access to the user.
 *
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class AccessValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(AccessValidator.class);

    /**
     * Checks for matching the login and password entered by the user
     * with the data in the system.
     *
     * @param request
     * @return true if conditions are met.
     */
    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            String expectedPassword = userService.getPassword(login);

            if (password.equals(expectedPassword)) {
                return true;
            }
        } catch (DataSourceException e) {
            LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
        } catch (ServiceSQLException e) {
            LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
        }
        return false;
    }
}

package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.User;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.logical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class SignInCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(SignInCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConstantContainer.SIGN_IN_PAGE;

        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);

        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator lengthValidator = validatorFactory.getLoginPassLengthValidator();
        Validator accessValidator = validatorFactory.getAccessValidator();

        if (lengthValidator.validate(request)) {
            if (accessValidator.validate(request)) {

                try {
                    ServiceFactory serviceFactory = ServiceFactory.getInstance();
                    UserService userService = serviceFactory.getUserService();

                    User user = userService.signIn(login, password);

                    request.getSession().setAttribute(ConstantContainer.LOGIN, user.getLogin());
                    request.getSession().setAttribute(ConstantContainer.USER_ID, user.getId());
                    request.getSession().setAttribute(ConstantContainer.USER_TYPE, user.getType());
                    request.getSession().setAttribute(ConstantContainer.LOGIN, user.getLogin());
                    request.getSession().setAttribute(ConstantContainer.PASSWORD, user.getPassword());
                    request.getSession().setAttribute(ConstantContainer.BALANCE, user.getBalance());
//                    int disc = (int) ((1 - user.getDiscount())*100) + 1;
                    request.getSession().setAttribute(ConstantContainer.DISCOUNT, user.getDiscount());

                    page = ConstantContainer.INDEX_PAGE;
                } catch (DataSourceException e) {
                    LOGGER.error(ConstantContainer.DATA_SOURCE_ERR_MSG, e);
                } catch (ServiceSQLException e) {
                    LOGGER.error(ConstantContainer.SQL_ERR_MSG, e);
                }
            } else {
                request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_LOGIN_ERROR);
            }
        } else {
            request.setAttribute(ConstantContainer.SHORT_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_SHORT_LOGIN_PASS);
        }

        return page;
    }
}

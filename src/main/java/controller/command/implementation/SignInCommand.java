package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.User;
import model.logic.exception.logical.ServiceSQLException;
import model.logic.exception.technical.DataSourceException;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class SignInCommand implements Command {

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
                    request.setAttribute(ConstantContainer.USER_ID, user.getId());
                    request.setAttribute(ConstantContainer.USER_TYPE, user.getType());
                    request.setAttribute(ConstantContainer.LOGIN, user.getLogin());
                    request.setAttribute(ConstantContainer.PASSWORD, user.getPassword());
                    request.setAttribute(ConstantContainer.BALANCE, user.getBalance());
                    request.setAttribute(ConstantContainer.DISCOUNT, user.getDiscount());

                    page = ConstantContainer.MAIN_PAGE;
                } catch (DataSourceException e) {
                    //log
                } catch (ServiceSQLException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_LOGIN_ERROR);
            }
        } else {
            request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_SHORT_LOGIN_PASS);
        }

        return page;
    }
}

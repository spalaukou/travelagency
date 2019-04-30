package controller.command.implementation;

import controller.command.Command;
import model.ConstantContainer;
import model.entity.User;
import model.logic.service.ServiceFactory;
import model.logic.service.UserService;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import servlet.command.LoginLogic;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 22.04.2019
 * @project TravelAgency
 */

public class SignInCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator lengthValidator = validatorFactory.getLoginPassLengthValidator();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        if (lengthValidator.validate(request)) {
            User user = userService.signIn(request);

            if(user != null) {
                request.setAttribute(ConstantContainer.USER_ID, user.getId());
                request.setAttribute(ConstantContainer.USER_TYPE, user.getType());
                request.setAttribute(ConstantContainer.LOGIN, user.getLogin());
                request.setAttribute(ConstantContainer.PASSWORD, user.getPassword());
                request.setAttribute(ConstantContainer.BALANCE, user.getBalance());
                request.setAttribute(ConstantContainer.DISCOUNT, user.getDiscount());

                page = ConstantContainer.MAIN_PAGE;
            } else {
                request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_LOGIN_ERROR);
                page = ConstantContainer.SIGN_IN_PAGE;
            }

//            if (LoginLogic.checkLogin(login, password)) {
//                request.setAttribute(ConstantContainer.USER, login);
//
//                page = ConstantContainer.MAIN_PAGE;
//            } else {
//                request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_LOGIN_ERROR);
//                page = ConstantContainer.SIGN_IN_PAGE;
//            }

        } else {
            request.setAttribute(ConstantContainer.ERR_LOGIN_PASS_MSG, ConstantContainer.MESSAGE_SHORT_LOGIN_PASS);
            page = ConstantContainer.SIGN_IN_PAGE;
        }

        return page;
    }
}

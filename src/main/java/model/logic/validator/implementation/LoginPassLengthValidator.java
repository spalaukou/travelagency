package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class LoginPassLengthValidator implements Validator {

    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);

        return login.length() >= ConstantContainer.LOGIN_MIN_LENGTH
                && password.length() >= ConstantContainer.PASSWORD_MIN_LENGTH;
    }
}

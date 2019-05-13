package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * Validator responsible for checking the length of the login and password
 * that the User enters.
 *
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class LoginPassLengthValidator implements Validator {

    /**
     * Checks the length of the login and password for compliance with the minimum length.
     *
     * @param request
     * @return true if length of the login and password is sufficient.
     */
    @Override
    public boolean validate(HttpServletRequest request) {
        String login = request.getParameter(ConstantContainer.LOGIN);
        String password = request.getParameter(ConstantContainer.PASSWORD);

        return login.length() >= ConstantContainer.LOGIN_MIN_LENGTH
                && password.length() >= ConstantContainer.PASSWORD_MIN_LENGTH;
    }
}

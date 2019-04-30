package model.logic.validator.implementation;

import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 30.04.2019
 * @project TravelAgency
 */

public class AccessValidator implements Validator {

    @Override
    public boolean validate(HttpServletRequest request) {
        return false;
    }
}

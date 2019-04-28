package model.logic.validator;

import model.logic.validator.implementation.LoginValidator;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class ValidatorFactory {
    private static final ValidatorFactory INSTANCE = new ValidatorFactory();
    private final LoginValidator loginValidator = new LoginValidator();

    private ValidatorFactory() {}

    public static ValidatorFactory getInstance() {
        return INSTANCE;
    }

    public LoginValidator getLoginValidator() {
        return loginValidator;
    }
}

package model.logic.validator;

import model.logic.validator.implementation.AccessValidator;
import model.logic.validator.implementation.LoginPassLengthValidator;
import model.logic.validator.implementation.LoginValidator;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class ValidatorFactory {
    private static final ValidatorFactory INSTANCE = new ValidatorFactory();
    private final LoginValidator loginValidator = new LoginValidator();
    private final LoginPassLengthValidator loginPassLengthValidator = new LoginPassLengthValidator();
    private final AccessValidator accessValidator = new AccessValidator();

    private ValidatorFactory() {}

    public static ValidatorFactory getInstance() {
        return INSTANCE;
    }

    public LoginValidator getLoginValidator() {
        return loginValidator;
    }

    public LoginPassLengthValidator getLoginPassLengthValidator() {
        return loginPassLengthValidator;
    }

    public AccessValidator getAccessValidator() {
        return accessValidator;
    }
}

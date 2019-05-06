package model.logic.validator;

import model.logic.validator.implementation.AccessValidator;
import model.logic.validator.implementation.BalanceValidator;
import model.logic.validator.implementation.LoginPassLengthValidator;
import model.logic.validator.implementation.LoginValidator;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class ValidatorFactory {
    private static final ValidatorFactory INSTANCE = new ValidatorFactory();
    private final Validator loginValidator = new LoginValidator();
    private final Validator loginPassLengthValidator = new LoginPassLengthValidator();
    private final Validator accessValidator = new AccessValidator();
    private final Validator balanceValidator = new BalanceValidator();

    private ValidatorFactory() {}

    public static ValidatorFactory getInstance() {
        return INSTANCE;
    }

    public Validator getLoginValidator() {
        return loginValidator;
    }

    public Validator getLoginPassLengthValidator() {
        return loginPassLengthValidator;
    }

    public Validator getAccessValidator() {
        return accessValidator;
    }

    public Validator getBalanceValidator() {
        return balanceValidator;
    }
}

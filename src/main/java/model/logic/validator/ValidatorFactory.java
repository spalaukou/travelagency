package model.logic.validator;

import model.logic.validator.implementation.*;

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
    private final Validator addTourDataValidator = new AddTourDataValidator();
    private final Validator updateTourDataValidator = new UpdateTourDataValidator();

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

    public Validator getAddTourDataValidator() {
        return addTourDataValidator;
    }

    public Validator getUpdateTourDataValidator() {
        return updateTourDataValidator;
    }
}

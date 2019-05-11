package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import org.apache.struts.mock.MockHttpServletRequest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Stanislau Palaukou on 11.05.2019
 * @project TravelAgency
 */

public class LoginValidatorTest {

    @Test
    public void testValidateNewUserTrue() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getLoginValidator();
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.LOGIN, "newUser");

        assertTrue(validator.validate(mockRequest));
    }

    @Test
    public void testValidateUserExistsTrue() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator loginValidator = validatorFactory.getLoginValidator();
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.LOGIN, "stas");

        assertTrue(loginValidator.validate(mockRequest));
    }

}
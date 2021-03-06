package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import org.apache.struts.mock.MockHttpServletRequest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Stanislau Palaukou on 11.05.2019
 * @project TravelAgency
 */

public class LoginValidatorTest {

    private Validator loginValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        loginValidator = validatorFactory.getLoginValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateNewUser() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "newUser");

        assertTrue(loginValidator.validate(mockRequest));
    }

    @Test
    public void testValidateExistingUser() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "stas");

        assertFalse(loginValidator.validate(mockRequest));
    }

}
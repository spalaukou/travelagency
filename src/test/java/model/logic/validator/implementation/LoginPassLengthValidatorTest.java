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

public class LoginPassLengthValidatorTest {

    private Validator loginPassLengthValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        loginPassLengthValidator = validatorFactory.getLoginPassLengthValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateTrue() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "longLogin");
        mockRequest.addParameter(ConstantContainer.PASSWORD, "longPassword");

        assertTrue(loginPassLengthValidator.validate(mockRequest));
    }

    @Test
    public void testValidateShortLoginFalse() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "sh");
        mockRequest.addParameter(ConstantContainer.PASSWORD, "tooShortLogin");

        assertFalse(loginPassLengthValidator.validate(mockRequest));
    }

    @Test
    public void testValidateShortPasswordFalse() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "tooShortPassword");
        mockRequest.addParameter(ConstantContainer.PASSWORD, "p");

        assertFalse(loginPassLengthValidator.validate(mockRequest));
    }

    @Test
    public void testValidateEmptyLoginPasswordFalse() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "");
        mockRequest.addParameter(ConstantContainer.PASSWORD, "");

        assertFalse(loginPassLengthValidator.validate(mockRequest));
    }
}
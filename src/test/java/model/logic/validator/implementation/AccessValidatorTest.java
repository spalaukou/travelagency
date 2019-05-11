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

public class AccessValidatorTest {

    private Validator accessValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        accessValidator = validatorFactory.getAccessValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateNonexistentUser() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "nonexistentUser");
        mockRequest.addParameter(ConstantContainer.PASSWORD, "nonexistentPassword");

        assertFalse(accessValidator.validate(mockRequest));
    }

    @Test
    public void testValidateExistingUser() {
        mockRequest.addParameter(ConstantContainer.LOGIN, "admin");
        mockRequest.addParameter(ConstantContainer.PASSWORD, "admin");

        assertTrue(accessValidator.validate(mockRequest));
    }
}
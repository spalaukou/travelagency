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

public class OrderExistsValidatorTest {

    private Validator orderExistsValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        orderExistsValidator = validatorFactory.getOrderExistsValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateFalse() {
        mockRequest.addParameter(ConstantContainer.ID, "1");

        assertFalse(orderExistsValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrue() {
        mockRequest.addParameter(ConstantContainer.ID, "40");

        assertTrue(orderExistsValidator.validate(mockRequest));
    }
}
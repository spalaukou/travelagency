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

public class BalanceValidatorTest {

    private Validator balanceValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        balanceValidator = validatorFactory.getBalanceValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateTrue() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.getSession().setAttribute(ConstantContainer.LOGIN, "admin");
        mockRequest.getSession().setAttribute(ConstantContainer.DISCOUNT, 1.0f);
        mockRequest.addParameter(ConstantContainer.TOTAL_PRICE, "1000");

        assertTrue(balanceValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongTourID() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "2");
        mockRequest.getSession().setAttribute(ConstantContainer.LOGIN, "admin");
        mockRequest.getSession().setAttribute(ConstantContainer.DISCOUNT, 1.0f);
        mockRequest.addParameter(ConstantContainer.TOTAL_PRICE, "1000");

        assertFalse(balanceValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongLogin() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.getSession().setAttribute(ConstantContainer.LOGIN, "nonexistentUser");
        mockRequest.getSession().setAttribute(ConstantContainer.DISCOUNT, 1.0f);
        mockRequest.addParameter(ConstantContainer.TOTAL_PRICE, "1000");

        assertFalse(balanceValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongDiscount() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.getSession().setAttribute(ConstantContainer.LOGIN, "admin");
        mockRequest.getSession().setAttribute(ConstantContainer.DISCOUNT, 0.9f);
        mockRequest.addParameter(ConstantContainer.TOTAL_PRICE, "1000");

        assertFalse(balanceValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongTotalPrice() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.getSession().setAttribute(ConstantContainer.LOGIN, "admin");
        mockRequest.getSession().setAttribute(ConstantContainer.DISCOUNT, 1.0f);
        mockRequest.addParameter(ConstantContainer.TOTAL_PRICE, "900");

        assertFalse(balanceValidator.validate(mockRequest));
    }

}
package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;
import model.logic.validator.ValidatorFactory;
import org.apache.struts.mock.MockHttpServletRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Stanislau Palaukou on 11.05.2019
 * @project TravelAgency
 */

public class UpdateTourDataValidatorTest {

    private Validator updateTourValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        updateTourValidator = validatorFactory.getUpdateTourDataValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateTrue() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertTrue(updateTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongTourID() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, null);
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(updateTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongTourCost() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, null);
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(updateTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateWrongTourHot() {
        mockRequest.addParameter(ConstantContainer.TOUR_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, null);

        assertFalse(updateTourValidator.validate(mockRequest));
    }
}
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

public class AddTourDataValidatorTest {

    private Validator addTourValidator;
    private MockHttpServletRequest mockRequest;

    @BeforeMethod
    public void setUp() {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        addTourValidator = validatorFactory.getAddTourDataValidator();
        mockRequest = new MockHttpServletRequest();
    }

    @Test
    public void testValidateTrue() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, "1");
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertTrue(addTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrueWrongTourType() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, null);
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, "1");
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(addTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrueWrongHotelID() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, null);
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, "1");
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(addTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrueWrongTourNight() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, null);
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(addTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrueWrongTransportType() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, "1");
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, null);
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(addTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrueWrongTourCost() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, "1");
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, null);
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, "1");

        assertFalse(addTourValidator.validate(mockRequest));
    }

    @Test
    public void testValidateTrueWrongTourHot() {
        mockRequest.addParameter(ConstantContainer.TOUR_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.HOTEL_ID, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_NIGHT, "1");
        mockRequest.addParameter(ConstantContainer.TRANSPORT_TYPE, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_COST, "1");
        mockRequest.addParameter(ConstantContainer.TOUR_HOT, null);

        assertFalse(addTourValidator.validate(mockRequest));
    }
}
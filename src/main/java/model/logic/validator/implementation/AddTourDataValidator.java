package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 10.05.2019
 * @project TravelAgency
 */
public class AddTourDataValidator implements Validator {

    @Override
    public boolean validate(HttpServletRequest request) {
        String tourType = request.getParameter(ConstantContainer.TOUR_TYPE);
        String hotelCountry = request.getParameter(ConstantContainer.HOTEL_ID);
        String hotelNight = request.getParameter(ConstantContainer.TOUR_NIGHT);
        String transport = request.getParameter(ConstantContainer.TRANSPORT_TYPE);
        String tourCost = request.getParameter(ConstantContainer.TOUR_COST);
        String tourHot = request.getParameter(ConstantContainer.TOUR_HOT);

        return tourType != null
                && hotelCountry != null
                && hotelNight != null
                && transport != null
                && tourCost != null
                && tourHot != null;
    }
}

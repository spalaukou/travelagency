package model.logic.validator.implementation;

import model.ConstantContainer;
import model.logic.validator.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * Data validator that is sent in the request.
 *
 * @author Stanislau Palaukou on 10.05.2019
 * @project TravelAgency
 */
public class UpdateTourDataValidator implements Validator {

    /**
     * Verification of all data sent in the request.
     *
     * @param request
     * @return true if all requested data exists.
     */
    @Override
    public boolean validate(HttpServletRequest request) {
        String tourID = request.getParameter(ConstantContainer.TOUR_ID);
        String tourCost = request.getParameter(ConstantContainer.TOUR_COST);
        String tourHot = request.getParameter(ConstantContainer.TOUR_HOT);

        return tourID != null && tourCost != null && tourHot != null
                && Integer.valueOf(tourID) > 0
                && Integer.valueOf(tourCost) >= 1
                && Integer.valueOf(tourCost) <= 10000
                && Float.valueOf(tourHot) >= 0.7f
                && Float.valueOf(tourHot) <= 1.0f;
    }
}

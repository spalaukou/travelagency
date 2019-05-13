package model.logic.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * The basic interface for all validators in the application.
 *
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public interface Validator {

    /**
     * Validates the data in the request.
     *
     * @param request
     * @return boolean variable, depended on if conditions are met or not.
     */
    boolean validate(HttpServletRequest request);
}

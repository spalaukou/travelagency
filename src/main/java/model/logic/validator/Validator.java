package model.logic.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public interface Validator {

    boolean validate(HttpServletRequest request);
}

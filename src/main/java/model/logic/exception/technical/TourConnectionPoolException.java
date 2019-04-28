package model.logic.exception.technical;

import model.logic.exception.TravelAgencyException;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class TourConnectionPoolException extends TravelAgencyException {
    public TourConnectionPoolException() {
        super();
    }

    public TourConnectionPoolException(String message) {
        super(message);
    }

    public TourConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourConnectionPoolException(Throwable cause) {
        super(cause);
    }

    protected TourConnectionPoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package model.logic.exception;

/**
 * Main exception for all exception in the application.
 *
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 */

public class TravelAgencyException extends Exception {
    public TravelAgencyException() {
        super();
    }

    public TravelAgencyException(String message) {
        super(message);
    }

    public TravelAgencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public TravelAgencyException(Throwable cause) {
        super(cause);
    }

    protected TravelAgencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

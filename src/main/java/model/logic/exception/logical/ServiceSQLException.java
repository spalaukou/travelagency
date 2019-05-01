package model.logic.exception.logical;

import model.logic.exception.TravelAgencyException;

/**
 * @author Stanislau Palaukou on 01.05.2019
 * @project TravelAgency
 */

public class ServiceSQLException extends TravelAgencyException {
    public ServiceSQLException() {
        super();
    }

    public ServiceSQLException(String message) {
        super(message);
    }

    public ServiceSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceSQLException(Throwable cause) {
        super(cause);
    }

    protected ServiceSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

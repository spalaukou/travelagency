package model.logic.exception.technical;

import model.logic.exception.TravelAgencyException;

/**
 * @author Stanislau Palaukou on 27.04.2019
 * @project TravelAgency
 */

public class DAOSQLException extends TravelAgencyException {
    public DAOSQLException() {
        super();
    }

    public DAOSQLException(String message) {
        super(message);
    }

    public DAOSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOSQLException(Throwable cause) {
        super(cause);
    }

    protected DAOSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

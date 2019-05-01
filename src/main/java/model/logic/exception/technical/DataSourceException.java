package model.logic.exception.technical;

import model.logic.exception.TravelAgencyException;

/**
 * @author Stanislau Palaukou on 01.05.2019
 * @project TravelAgency
 */

public class DataSourceException extends TravelAgencyException {
    public DataSourceException() {
        super();
    }

    public DataSourceException(String message) {
        super(message);
    }

    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSourceException(Throwable cause) {
        super(cause);
    }

    protected DataSourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

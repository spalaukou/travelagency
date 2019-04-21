package model.logic.exception.technical;

import model.logic.exception.TravelAgencyException;

/**
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 */

public class DBconnectionException extends TravelAgencyException {

    private static final String MESSAGE = "Can not connect to the database.";

    public DBconnectionException(){
        super(MESSAGE);
    }
}

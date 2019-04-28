package model.logic.dal.db_connection.transaction;


/**
 * @author Stanislau Palaukou on 26.04.2019
 * @project TravelAgency
 */

public interface UserTransaction {

    int signUp(String login, String password);
}

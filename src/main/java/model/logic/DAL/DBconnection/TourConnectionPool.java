package model.logic.DAL.DBconnection;

import model.logic.exception.technical.DBconnectionException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Stanislau Palaukou on 21.04.2019
 * @project TravelAgency
 */

public class TourConnectionPool {

    private static DataSource datasource;

    private TourConnectionPool() {
    }

    public static synchronized DataSource getConnection() throws DBconnectionException {
        if (datasource == null) {
            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                datasource = (DataSource) envCtx.lookup("jdbc/tour");
            } catch (NamingException ex) {
                throw new DBconnectionException();
            }
        }
        return datasource;
    }

}

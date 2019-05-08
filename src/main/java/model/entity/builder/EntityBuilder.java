package model.entity.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Stanislau Palaukou on 09.05.2019
 * @project TravelAgency
 */

public interface EntityBuilder<T> {

    T build(ResultSet resultSet) throws SQLException;

}

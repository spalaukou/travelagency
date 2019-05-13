package model.entity.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Generic class for building any types of entities from ResultSet.
 *
 * @author Stanislau Palaukou on 09.05.2019
 * @project TravelAgency
 */

public interface EntityBuilder<T> {

    /**
     * Builds an entity.
     *
     * @param resultSet
     * @return types of entity.
     * @throws SQLException
     */
    T build(ResultSet resultSet) throws SQLException;

}

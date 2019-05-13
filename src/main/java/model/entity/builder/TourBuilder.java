package model.entity.builder;

import model.entity.Hotel;
import model.entity.Tour;
import model.entity.Transport;
import model.logic.dal.db_connection.DBConstantContainer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for building the Tour from ResultSet.
 *
 * @author Stanislau Palaukou on 09.05.2019
 * @project TravelAgency
 */

public class TourBuilder implements EntityBuilder<Tour> {

    /**
     * Builds a Tour entity.
     *
     * @param resultSet
     * @return Tour entity.
     * @throws SQLException
     */
    @Override
    public Tour build(ResultSet resultSet) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getInt(DBConstantContainer.TOUR_ID_TOUR));
        tour.setName(resultSet.getString(DBConstantContainer.TOUR_NAME));

        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getInt(DBConstantContainer.HOTEL_ID_HOTEL));
        hotel.setName(resultSet.getString(DBConstantContainer.HOTEL_NAME));
        hotel.setCountry(resultSet.getString(DBConstantContainer.HOTEL_COUNTRY));
        hotel.setCity(resultSet.getString(DBConstantContainer.HOTEL_CITY));
        hotel.setStar(resultSet.getInt(DBConstantContainer.HOTEL_STAR));
        hotel.setMeal(resultSet.getString(DBConstantContainer.HOTEL_MEAL));
        hotel.setPerson(resultSet.getInt(DBConstantContainer.HOTEL_PERSON));
        tour.setHotel(hotel);

        tour.setNight(resultSet.getInt(DBConstantContainer.TOUR_NIGHT));

        Transport transport = new Transport();
        transport.setId(resultSet.getInt(DBConstantContainer.TRANSPORT_ID_TRANSPORT));
        transport.setType(resultSet.getString(DBConstantContainer.TRANSPORT_TYPE));
        tour.setTransport(transport);

        tour.setCost(resultSet.getInt(DBConstantContainer.TOUR_COST));
        tour.setHot(resultSet.getFloat(DBConstantContainer.TOUR_HOT));

        return tour;
    }
}

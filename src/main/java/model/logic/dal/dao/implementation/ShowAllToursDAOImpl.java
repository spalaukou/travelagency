package model.logic.dal.dao.implementation;

import model.entity.UserTour;
import model.logic.dal.dao.ShowAllToursDAO;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.ConnectionPool;
import model.logic.dal.db_connection.connection_pool.TourConnectionPool;
import model.logic.exception.technical.TourConnectionPoolException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class ShowAllToursDAOImpl implements ShowAllToursDAO {

    @Override
    public List<UserTour> getList() {
//        TourConnectionPool tourConnectionPool = TourConnectionPool.getInstance();
//        Connection connection = null;
//        try {
//            connection = tourConnectionPool.getConnection();
//        } catch (TourConnectionPoolException e) {
//            e.printStackTrace();
//        }

        Connection connection = ConnectionPool.getConnection();
        List<UserTour> list;

        {
            list = new ArrayList<>();
        }

        try {
            Statement statement = connection.createStatement();
            String sql = DBRequestContainer.GET_ALL_TOURS;

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                UserTour userTour = new UserTour();
                userTour.setCountry(resultSet.getString("hotel.country"));
                userTour.setCity(resultSet.getString("hotel.city"));
                userTour.setHotelName(resultSet.getString("hotel.name"));
                userTour.setStar(resultSet.getInt("hotel.star"));
                userTour.setMeal(resultSet.getString("hotel.meal"));
                userTour.setPerson(resultSet.getInt("hotel.person"));
                userTour.setNight(resultSet.getInt("tour.night"));
                userTour.setTransportType(resultSet.getString("transport.type"));
                userTour.setCost(resultSet.getInt("tour.cost"));
                userTour.setHot(resultSet.getFloat("tour.hot"));
                userTour.setUserCost();
                list.add(userTour);

//                System.out.print(resultSet.getString("hotel.country") + " ");
//                System.out.print(resultSet.getString("hotel.city") + " ");
//                System.out.print(resultSet.getString("hotel.name") + " ");
//                System.out.print(resultSet.getInt("hotel.star") + " ");
//                System.out.print(resultSet.getString("hotel.meal") + " ");
//                System.out.print(resultSet.getInt("hotel.person") + " ");
//                System.out.print(resultSet.getInt("tour.night") + " ");
//                System.out.print(resultSet.getString("transport.type") + " ");
//                System.out.print(resultSet.getInt("tour.cost") + " ");
//                System.out.print(resultSet.getFloat("tour.hot") + " ");
//                System.out.println();
            }
//            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

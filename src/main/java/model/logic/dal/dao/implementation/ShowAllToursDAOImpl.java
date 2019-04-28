package model.logic.dal.dao.implementation;

import model.entity.UserTour;
import model.logic.dal.dao.ShowAllToursDAO;
import model.logic.dal.db_connection.DBRequestContainer;
import model.logic.dal.db_connection.connection_pool.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Stanislau Palaukou on 28.04.2019
 * @project TravelAgency
 */

public class ShowAllToursDAOImpl implements ShowAllToursDAO {

    @Override
    public List<UserTour> getList() {
        Connection connection = ConnectionPool.getConnection();
        List<UserTour> list = null;

        try {
            Statement statement = connection.createStatement();
            String sql = DBRequestContainer.GET_ALL_TOURS;

            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("hello");

            while(resultSet.next()) {
                System.out.print(resultSet.getString("hotel.country") + " ");
                System.out.print(resultSet.getString("hotel.city") + " ");
                System.out.print(resultSet.getString("hotel.name") + " ");
                System.out.print(resultSet.getInt("hotel.star") + " ");
                System.out.print(resultSet.getString("hotel.meal") + " ");
                System.out.print(resultSet.getInt("hotel.person") + " ");
                System.out.print(resultSet.getInt("tour.night") + " ");
                System.out.print(resultSet.getString("transport.type") + " ");
                System.out.print(resultSet.getInt("tour.cost") + " ");
                System.out.print(resultSet.getFloat("tour.hot") + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

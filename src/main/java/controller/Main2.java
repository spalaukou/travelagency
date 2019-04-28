package controller;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Stanislau Palaukou on 10.04.2019
 * @project TravelAgency
 */

public class Main2 {
    private static String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/student?useTimezone=true&serverTimezone=UTC";
    private static String DATABASE_USER = "root";
    private static String DATABASE_PASSWORD = "root";

    private static String SQL2 = "INSERT INTO `tour`.`user` (`login`, `password`) VALUES (?, ?);";

    public static void main(String[] args) {

        Connection connection = null;
        try {
            //загрузка класса в память без создания экземпляра
            Class.forName(JDBC_MYSQL_DRIVER);

//            connection = PooledConnection.getConnection(); // how it works, TOmcat предоставляет свой пул
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            //run to check connection !!!

            //Statement statement = connection.createStatement();
//            PreparedStatement statement = connection.prepareStatement(SQL);
//            CallableStatement statement = connection.prepareCall("{ call getStudent(?)}");


//            statement.setInt(1, id); // IN
//            int temp = 0;
//            statement.registerOutParameter(2, Types.INTEGER);
//            statement.setInt(2, temp); // OUT

            String sql = SQL2;
//            String sql = SQL + " WHERE idstudent = " + id + "; drop table group";
//
//            System.out.println(sql);

            CallableStatement statement = connection.prepareCall(sql);

            statement.setString(1, "mmm");
            statement.setString(2, "1");
            statement.execute();


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
//        finally {
//            if(connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.out.println(e);
//                }
//            }
//        }
    }
}


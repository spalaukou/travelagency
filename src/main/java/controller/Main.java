package controller;

import javax.sql.PooledConnection;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Stanislau Palaukou on 10.04.2019
 * @project TravelAgency
 */

public class Main {
    private static String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/student?useTimezone=true&serverTimezone=UTC";
    private static String DATABASE_USER = "root";
    private static String DATABASE_PASSWORD = "root";

    //    private static String SQL = "SELECT * FROM student";
//    private static String SQL = "SELECT * FROM student WHERE idstudent = ? AND idgroup > ?";
    private static String SQL = "SELECT * FROM student WHERE idstudent = ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input student id: ");
        int id = scanner.nextInt();

        Connection connection = null;
        try {
            //загрузка класса в память без создания экземпляра
            Class.forName(JDBC_MYSQL_DRIVER);

//            connection = PooledConnection.getConnection(); // how it works, TOmcat предоставляет свой пул
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            //run to check connection !!!

            Statement statement = connection.createStatement();
//            PreparedStatement statement = connection.prepareStatement(SQL);
//            CallableStatement statement = connection.prepareCall("{ call getStudent(?)}");


//            statement.setInt(1, id); // IN
//            int temp = 0;
//            statement.registerOutParameter(2, Types.INTEGER);
//            statement.setInt(2, temp); // OUT

            String sql = SQL + id;
//            String sql = SQL + " WHERE idstudent = " + id + "; drop table group";
//
//            System.out.println(sql);

            ResultSet resultSet = statement.executeQuery(sql); //sql


            while(resultSet.next()) { //id name group
                System.out.print(resultSet.getInt("idstudent") + " ");
                System.out.print(resultSet.getString("stname") + " ");
                System.out.println(resultSet.getInt("idgroup")); //null -> to 0
            }

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


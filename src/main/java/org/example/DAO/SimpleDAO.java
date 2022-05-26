package org.example.DAO;

import org.example.models.Person;
import org.example.models.Simple;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/new_db";
    private static final String USERNAME = "root";
    private static final String PASS = "root";

    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            System.out.println("Connection is established");
            System.out.println("Database name is: " + connection.getMetaData().getDatabaseProductName());
        } catch (SQLException e) {
            System.out.println("Unable to connect to db");
            e.printStackTrace();
        }
    }

    public List<Simple> list(){
        List<Simple> simpleList = new ArrayList<>();

        System.out.println("getting values from table");

        try{
            String SQL = "SELECT * FROM Simple";
            //System.out.println("1");
            PreparedStatement statement = connection.prepareStatement(SQL);
            //System.out.println("2");
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Statement prepared!");

            while(resultSet.next()){
                Simple simple = new Simple();
                simple.setName(resultSet.getString("name"));

                //Checking what we get
                System.out.println(simple);

                simpleList.add(simple);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return simpleList;
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital_queue",
                "root",
                "root1234*"
            );

            System.out.println("Database Connected Successfully");

        } catch(Exception e){

            System.out.println(e);

        }

        return con;
    }
}
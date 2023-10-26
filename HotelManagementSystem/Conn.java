package HotelManagementSystem;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {
        try {
            String username = "root";
            String password = "kartikcr7";
            String sqlURL = "jdbc:mysql://localhost:3306/HotelManagementSystem";
//            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(sqlURL, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

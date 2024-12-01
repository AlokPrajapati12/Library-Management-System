package Library_management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class config {
    Connection connection;
    Statement statement;
    public config() {
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management","root","root123");
            statement=connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

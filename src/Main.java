import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {

Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Eldaem03!");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM jdbc.user;");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name1"));


        }
    }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
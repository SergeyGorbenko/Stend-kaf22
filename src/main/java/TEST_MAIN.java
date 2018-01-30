import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.time.LocalDate;

public class TEST_MAIN {
    private static final String URL="jdbc:mysql://localhost:3306/mydb";
    private static final String LOGIN="root";
    private static final String PASSWORD="2611199813g";
    private static final String rule="INSERT INTO `table`(clas, grup, predmet, techer, para, date) VALUES ((?),(?),(?),(?),(?),(?))";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection=DriverManager.getConnection(URL,LOGIN,PASSWORD);
            Statement statement=connection.createStatement();
            final PreparedStatement preparedStatement=connection.prepareStatement(rule)){

            preparedStatement.setString(1,"230");
            preparedStatement.setInt(2,261);
            preparedStatement.setString(3,"KM");
            preparedStatement.setString(4,"Simon");
            preparedStatement.setInt(5,2);
            preparedStatement.setDate(6,new Date(2018,1,29));
            preparedStatement.executeUpdate();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `table`");
            while (resultSet.next()){
                Date date = resultSet.getDate(6);
                System.out.println(date.toLocalDate());
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

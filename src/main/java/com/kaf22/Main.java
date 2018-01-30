package com.kaf22;

import com.kaf22.Controllers.Clock;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.*;
import java.util.Date;

public class Main extends Application {
    private static final String URL="jdbc:mysql://localhost:3306/mydb";
    private static final String LOGIN="root";
    private static final String PASSWORD="2611199813g";
    private static final String RULE="SELECT * FROM `table` WHERE (?)";

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/SchemeOfKafedra.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("Stend");
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private static void conectBD() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection=DriverManager.getConnection(URL,LOGIN,PASSWORD);
            final PreparedStatement preparedStatement=connection.prepareStatement(RULE)){
            preparedStatement.setDate(1, java.sql.Date.valueOf(Clock.dt.format(new Date())));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Table tb=new Table();
                tb.setAudit(resultSet.getString("clas"));
                tb.setGrup(resultSet.getInt("grup"));
                tb.setLeson(resultSet.getString("predmet"));
                tb.setTicher(resultSet.getString("techer"));
                tb.setPara(resultSet.getInt("para"));
                tb.setDate(resultSet.getDate("date"));
                BD.getTable().add(tb);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //conectBD();
        launch(args);
    }

}

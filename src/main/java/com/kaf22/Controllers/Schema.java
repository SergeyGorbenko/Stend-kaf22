package com.kaf22.Controllers;

import com.kaf22.BD;
import com.kaf22.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Schema implements Initializable {
    @FXML
    private Label g230;
    @FXML
    private Label g226;
    @FXML
    private Label g224;
    @FXML
    private Label g223;
    @FXML
    private Label g223a;
    @FXML
    private Label g221;
    @FXML
    private Label g219;
    @FXML
    private Label g219a;

    @FXML
    private Label v230;
    @FXML
    private Label v226;
    @FXML
    private Label v224;
    @FXML
    private Label v223;
    @FXML
    private Label v223a;
    @FXML
    private Label v221;
    @FXML
    private Label v219;
    @FXML
    private Label v219a;

    @FXML
    private Pane a230;
    @FXML
    private Pane a226;
    @FXML
    private Pane a224;
    @FXML
    private Pane a223;
    @FXML
    private Pane a223a;
    @FXML
    private Pane a221;
    @FXML
    private Pane a219;
    @FXML
    private Pane a219a;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String time = Clock.tm.format(new Date());
        int para=-1;
        String[] dz= new String[]{"09:00","10:50","12:40","15:45","17:25"};
        for (int i = 0; i <dz.length ; i++)  {
            if(time.compareTo(dz[i])>0) {
                para = i + 1;
            }
        }

        show(para);
    }

    private void show(int i) {
        for (Table t: BD.getTable()) {
            if (t.getPara() == i) {
                switch (t.getAudit()) {
                    case "219":
                        if (t.getGrup() == 0)
                            a219.setStyle("-fx-background-color: #006C04;");

                        else {
                            a219.setStyle("-fx-background-color: #ee0001;");
                            g219.setText(String.valueOf(t.getGrup()));
                            v219.setText(t.getTicher());
                        }
                        break;
                    case "219a":
                        if (t.getGrup() == 0)
                            a219a.setStyle("-fx-background-color: #006C04;");
                        else {
                            a219a.setStyle("-fx-background-color: #ee0001;");
                            g219a.setText(String.valueOf(t.getGrup()));
                            v219a.setText(t.getTicher());
                        }
                        break;
                    case "221":
                        if (t.getGrup() == 0)
                            a221.setStyle("-fx-background-color: #006C04;");
                        else {
                            a221.setStyle("-fx-background-color: #ee0001;");
                            g221.setText(String.valueOf(t.getGrup()));
                            v221.setText(t.getTicher());
                        }
                        break;
                    case "223":
                        if (t.getGrup() == 0)
                            a223.setStyle("-fx-background-color: #006C04;");
                        else {
                            a223.setStyle("-fx-background-color: #ee0001;");
                            g223.setText(String.valueOf(t.getGrup()));
                            v223.setText(t.getTicher());
                        }
                        break;
                    case "223a":
                        if (t.getGrup() == 0)
                            a223a.setStyle("-fx-background-color: #006C04;");

                        else {
                            a223a.setStyle("-fx-background-color: #ee0001;");
                            g223a.setText(String.valueOf(t.getGrup()));
                            v223a.setText(t.getTicher());
                        }
                        break;
                    case "224":
                        if (t.getGrup() == 0)
                            a224.setStyle("-fx-background-color: #006C04;");
                        else {
                            a224.setStyle("-fx-background-color: #ee0001;");
                            g224.setText(String.valueOf(t.getGrup()));
                            v224.setText(t.getTicher());
                        }
                        break;
                    case "226":
                        if (t.getGrup() == 0)
                            a226.setStyle("-fx-background-color: #006C04;");
                        else {
                            a226.setStyle("-fx-background-color: #ee0001;");
                            g226.setText(String.valueOf(t.getGrup()));
                            v226.setText(t.getTicher());
                        }
                        break;
                    case "230":
                        if (t.getGrup() == 0)
                            a230.setStyle("-fx-background-color: #006C04;");
                        else {
                            a230.setStyle("-fx-background-color: #ee0001;");
                            g230.setText(String.valueOf(t.getGrup()));
                            v230.setText(t.getTicher());
                        }
                        break;
                }
            }
        }
    }
}

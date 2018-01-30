package com.kaf22.Controllers;

import com.kaf22.BD;
import com.kaf22.Table;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Tabl implements Initializable {
    @FXML
    private Label g1,g2,g3,g4,g5,g6,g7,g8;
    @FXML
    private Label p1,p2,p3,p4,p5,p6,p7,p8;
    @FXML
    private Label a1,a2,a3,a4,a5,a6,a7,a8;
    @FXML
    private Label v1,v2,v3,v4,v5,v6,v7,v8;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String time = Clock.tm.format(new Date());
        int para=-1;
        String[] dz= new String[]{"09:00","10:50","12:40","15:45","17:25"};
        for (int i = 0; i <dz.length ; i++)  {
            if(time.compareTo(dz[i])<0) {
                para = i + 1;
                break;
            }
        }
        show(para);
    }

    private void show(int para) {
        Field[] fields = getClass().getDeclaredFields();
        Field[] g= (Field[])(Arrays.stream(fields).filter(f->f.getName().startsWith("g")).collect(Collectors.toList())).toArray();
        Field[] p= (Field[])(Arrays.stream(fields).filter(f->f.getName().startsWith("p")).collect(Collectors.toList())).toArray();
        Field[] a= (Field[])(Arrays.stream(fields).filter(f->f.getName().startsWith("a")).collect(Collectors.toList())).toArray();
        Field[] v= (Field[])(Arrays.stream(fields).filter(f->f.getName().startsWith("v")).collect(Collectors.toList())).toArray();
        ArrayList<Table> table = BD.getTable();
        int j=0;
        for (int i = 0; i <table.size() ; i++) {
            if (table.get(i).getPara() == para) {
//                try {
//                    ((Label)(g[j].get(new Label()))).setText(table.get(i).getGrup());
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}

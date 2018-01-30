package com.kaf22.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Clock implements Initializable {

    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private Label pogoda;
    public final static SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat tm = new SimpleDateFormat("HH:mm");





    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] wether = new String[8];
        String[] times = new String[8];

            Date date = new Date();
            String url = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%BA%D0%B8%D0%B5%D0%B2/" + dt.format(date);
            try {
                Document page = Jsoup.parse(new URL(url), 0);
                Element tableWth = page.select("tr[class=temperature]").first();
                Element tableTimes=page.select("tr[class=gray time]").first();
                wether = tableWth.text().split(" ");
                String[] times1 = tableTimes.text().split("\\s");
                for (int i = 0; i < times1.length; i++) {
                    if(i%2==0) {
                        if (times1[i].length()==1)
                            times1[i]="0"+times1[i];
                        times[i/2] = times1[i] + times1[i + 1];
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            time.setText(tm.format(date));
            this.date.setText(dt.format(date));
        for (int i = 0; i < times.length; i++) {
            if((times[i].compareTo(tm.format(date))>0)) {
                pogoda.setText("Kiev "+wether[i]);
                break;
            }
        }
    }


}

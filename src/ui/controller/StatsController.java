/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import model.domain.Stats;

/**
 *
 * @author fsmag
 */
public class StatsController extends GridPane {

    @FXML
    private DatePicker datefin;

    @FXML
    private DatePicker datedebut;

    @FXML
    private LineChart chart;

    private final ShareShopFacade facade;

    public StatsController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/StatsView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
        valideDate(checkDD(), checkDF());
        chart.setTitle("Monthly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId(), checkDD(), checkDF());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyMonth(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats(checkDD(), checkDF());
        int numberUser = facade.getNumberUserStats();
        if (generalstats != null) {
            HashMap<String, Double> m = groupbyMonth(generalstats);
            for (String key : m.keySet()) {
                Double value = m.get(key) / numberUser;
                series2.getData().add(new XYChart.Data(key, value));
            }
        }
        chart.getData().addAll(series1, series2);

    }

    private HashMap groupbyMonth(List<Stats> stats) {
        HashMap<String, Double> liste = new HashMap<String, Double>();
        if (stats != null) {
            for (Stats s : stats) {
                Calendar d = Calendar.getInstance();
                d.setTime(s.getDate());
                String key = getMonthForInt(d.get(Calendar.MONTH)) + "-" + d.get(Calendar.YEAR);
                Double value = Double.parseDouble(Float.toString(s.getAmount()));
                if (!liste.containsKey(key)) {
                    liste.put(key, value);
                } else {
                    value = value + liste.get(key);
                    liste.put(key, value);
                }
            }
        }
        return liste;
    }

    private HashMap groupbyWeek(List<Stats> stats) {
        HashMap<String, Double> liste = new HashMap<String, Double>();
        if (stats != null) {
            for (Stats s : stats) {
                Calendar d = Calendar.getInstance();
                d.setTime(s.getDate());
                String key = d.get(Calendar.WEEK_OF_MONTH) + "-" + getMonthForInt(d.get(Calendar.MONTH)) + "-" + d.get(Calendar.YEAR);
                Double value = Double.parseDouble(Float.toString(s.getAmount()));
                if (!liste.containsKey(key)) {
                    liste.put(key, value);
                } else {
                    value = value + liste.get(key);
                    liste.put(key, value);
                }
            }
        }
        return liste;
    }

    private HashMap groupbyDay(List<Stats> stats) {
        HashMap<String, Double> liste = new HashMap<String, Double>();
        if (stats != null) {
            for (Stats s : stats) {
                Calendar d = Calendar.getInstance();
                d.setTime(s.getDate());
                String key = d.get(Calendar.DAY_OF_MONTH) + "-" + getMonthForInt(d.get(Calendar.MONTH)) + "-" + d.get(Calendar.YEAR);
                Double value = Double.parseDouble(Float.toString(s.getAmount()));
                if (!liste.containsKey(key)) {
                    liste.put(key, value);
                } else {
                    value = value + liste.get(key);
                    liste.put(key, value);
                }
            }
        }
        return liste;
    }

    private HashMap groupbyYear(List<Stats> stats) {
        HashMap<String, Double> liste = new HashMap<String, Double>();
        if (stats != null) {
            for (Stats s : stats) {
                Calendar d = Calendar.getInstance();
                d.setTime(s.getDate());
                String key = Integer.toString(d.get(Calendar.YEAR));
                Double value = Double.parseDouble(Float.toString(s.getAmount()));
                if (!liste.containsKey(key)) {
                    liste.put(key, value);
                } else {
                    value = value + liste.get(key);
                    liste.put(key, value);
                }
            }
        }
        return liste;
    }

    private String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }
    
    @FXML
    private void back(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new MyGroupsController());
            super.getChildren();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void day(ActionEvent event) {
        chart.getData().clear();
        valideDate(checkDD(), checkDF());
        chart.setTitle("Dayly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId(), checkDD(), checkDF());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyDay(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats(checkDD(), checkDF());
        int numberUser = facade.getNumberUserStats();
        if (generalstats != null) {
            HashMap<String, Double> m = groupbyDay(generalstats);
            for (String key : m.keySet()) {
                Double value = m.get(key) / numberUser;
                series2.getData().add(new XYChart.Data(key, value));
            }
        }

        chart.getData().addAll(series1, series2);

    }

    @FXML
    void month(ActionEvent event) {
        chart.getData().clear();
        valideDate(checkDD(), checkDF());
        chart.setTitle("Monthly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId(), checkDD(), checkDF());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyMonth(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats(checkDD(), checkDF());
        int numberUser = facade.getNumberUserStats();
        if (generalstats != null) {
            HashMap<String, Double> m = groupbyMonth(generalstats);
            for (String key : m.keySet()) {
                Double value = m.get(key) / numberUser;
                series2.getData().add(new XYChart.Data(key, value));
            }
        }
        chart.getData().addAll(series1, series2);

    }

    @FXML
    void week(ActionEvent event) {
        chart.getData().clear();
        valideDate(checkDD(), checkDF());
        chart.setTitle("Weekly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId(), checkDD(), checkDF());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyWeek(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats(checkDD(), checkDF());
        int numberUser = facade.getNumberUserStats();
        if (generalstats != null) {
            HashMap<String, Double> m = groupbyWeek(generalstats);
            for (String key : m.keySet()) {
                Double value = m.get(key) / numberUser;
                series2.getData().add(new XYChart.Data(key, value));
            }
        }

        chart.getData().addAll(series1, series2);
    }

    @FXML
    void year(ActionEvent event) {
        chart.getData().clear();
        valideDate(checkDD(), checkDF());
        chart.setTitle("Year Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId(), checkDD(), checkDF());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyYear(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats(checkDD(), checkDF());
        int numberUser = facade.getNumberUserStats();
        if (generalstats != null) {
            HashMap<String, Double> m = groupbyYear(generalstats);
            for (String key : m.keySet()) {
                Double value = m.get(key) / numberUser;
                series2.getData().add(new XYChart.Data(key, value));
            }
        }
        chart.getData().addAll(series1, series2);
    }

    private Date checkDD() {
        Date date = null;
        try {
            LocalDate localDate = datedebut.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            date = Date.from(instant);
        } catch (Exception e) {
        }
        return date;
    }

    private Date checkDF() {
        Date date = null;
        try {
            LocalDate localDate = datefin.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            date = Date.from(instant);
        } catch (Exception e) {
        }
        return date;
    }

    private void valideDate(Date dd, Date df) {
        if (dd != null && df != null) {
            if (df.compareTo(new Date()) > 0 || dd.compareTo(new Date()) > 0) {
                datedebut.setValue(null);
                datefin.setValue(null);
            } else if (df.compareTo(dd) < 0) {
                datefin.setValue(null);
            }
        }
        else if (dd != null){
            if ( dd.compareTo(new Date()) > 0) {
                datedebut.setValue(null);
                datefin.setValue(null);
            } 
        }
        else if(df != null){
            if (df.compareTo(new Date()) > 0 ) {
                datedebut.setValue(null);
                datefin.setValue(null);
            }
        }
    }
    
    @FXML
    void refresh(ActionEvent event) {
        month(event);
    }

}

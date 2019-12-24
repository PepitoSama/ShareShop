/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.GridPane;
import model.domain.Stats;

/**
 *
 * @author fsmag
 */
public class StatsController extends GridPane {

    @FXML
    private LineChart chart;

    private final ShareShopFacade facade;

    public StatsController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/Stats.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();

        chart.setTitle("Monthly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyMonth(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats();
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
    void day(ActionEvent event) {
        chart.getData().removeAll();
        chart.setTitle("Dayly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyDay(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats();
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
        chart.getData().removeAll();
        chart.setTitle("Monthly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyMonth(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats();
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
        chart.getData().removeAll();
        chart.setTitle("Weekly Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyWeek(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats();
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
        chart.getData().removeAll();
        chart.setTitle("Year Expenses");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amount in €");
        XYChart.Series<String, Double> series1 = new XYChart.Series<String, Double>();
        series1.setName("Me");
        List<Stats> mystats = facade.consultStats(facade.getUserManager().getUser().getId());
        if (mystats != null) {
            HashMap<String, Double> m = groupbyYear(mystats);
            for (String key : m.keySet()) {
                series1.getData().add(new XYChart.Data(key, m.get(key)));
            }
        }
        XYChart.Series<String, Double> series2 = new XYChart.Series<String, Double>();
        series2.setName("Average");
        List<Stats> generalstats = facade.consultStats();
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import ui.launch.*;
import bl.facade.*;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author fsmag
 */
public class MainTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("ShareShop");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

}

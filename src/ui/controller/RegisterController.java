package ui.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import java.awt.Color;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class RegisterController extends GridPane {

    @FXML
    private PasswordField passwordC;

    @FXML
    private PasswordField password;

    @FXML
    private TextField nickname;

    @FXML
    private TextField name;

    @FXML
    private TextField mail;

    @FXML
    private TextField lastname;

    @FXML
    private DatePicker age;

    @FXML
    private Text res;

    private final ShareShopFacade facade;

    public RegisterController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getClassLoader().getResource("ui/view/RegisterView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
    }

    @FXML
    void back(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new LoginController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    void register(ActionEvent event) {
        String nameV = name.getText();
        String passwordV = password.getText();
        String passwordCV = passwordC.getText();
        String mailV = mail.getText();
        String lastnameV = lastname.getText();
        String nicknameV = nickname.getText();
        Date ageV = null;
        try {
            LocalDate localDate = age.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            ageV = Date.from(instant);
        } catch (Exception e) {
            res.setText("Missing age");
            res.setFill(Paint.valueOf("red"));
        }
        try {
            if (facade.register(nicknameV, passwordV, nameV, lastnameV, ageV, mailV, passwordCV)) {
                try {
                    super.getChildren().clear();
					super.getChildren().add(new LoginController());
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        } catch (Exception e) {
            res.setText(e.getMessage());
            res.setFill(Paint.valueOf("red"));
        }

    }
}

package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WelcomePageController {
    @FXML
    private DatePicker dateField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String formattedDate;

    //getter and setter methods
    public String getFormattedDate(){
        return formattedDate;
    }

    public void switchToApp(ActionEvent event) throws IOException {

        //storing date in MM-DD-YYYY format
        LocalDate date = dateField.getValue();
        formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        //loads window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ViewDate.fxml"));
        root = fxmlLoader.load();

        //create object of AppController to gain access to methods (like displaying the typed-in year)
        ViewDateController appController = fxmlLoader.getController();
        //change the text in the App window to the year the user decided on
        appController.setDate(formattedDate);
        appController.displayDate();
        appController.listEventsAvailableForDay();

        //load the scene/window
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





}
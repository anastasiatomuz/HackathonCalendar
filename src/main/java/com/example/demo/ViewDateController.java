package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ViewDateController {
    @FXML
    Label dateLabel;
    private Stage stage;
    private Scene scene;

    public void displayDate(String date){
        dateLabel.setText(date);
    }

    //return to welcome page
    public void returnToWelcomePage(ActionEvent event) throws IOException {

        //loads window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WelcomePage.fxml"));
        //load the scene/window
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void viewEvent(ActionEvent e){


    }

    public void addNewEvent(ActionEvent e){

    }


}
package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewEventController {

    //instance variables
    private Parent root;
    private ViewDateController viewDateController;
    private String date;
    private Stage stage;
    private Scene scene;
    private Event event;

    @FXML
    TextArea hugeTextArea;

    public ViewEventController(){
        date = "";
    }

    public void setDate(String newDate){
        date = newDate;
    }

    public void setEvent(Event newEvent){
        event = newEvent;
    }

    public void returnMethod(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewDate.fxml"));
        root = fxmlLoader.load();

        viewDateController = fxmlLoader.getController();

        //set the date for the view date window
        viewDateController.setDate(date);
        viewDateController.displayDate();
        viewDateController.listEventsAvailableForDay();

        //load the scene/window
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayEventInfo(){
        hugeTextArea.appendText("Date: " + date + "\n");
        hugeTextArea.appendText("Title: " + event.getTitle() + "\n");
        hugeTextArea.appendText("All day: " + event.isAllDay() + "\n");
        hugeTextArea.appendText("Start Time: " + event.getStartTime() + "\n");
        hugeTextArea.appendText("End Time: " + event.getEndTime() + "\n");
        hugeTextArea.appendText("Notes: " + event.getInfo());

    }





}

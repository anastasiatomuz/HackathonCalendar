package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ViewDateController {
    @FXML
    private Label dateLabel;
    @FXML
    private TextArea displayCurrentEvents;
    @FXML
    private TextField eventToView;
    private Stage stage;
    private Scene scene;
    private String date;


    public void setDate(String newDate){
        date = newDate;
    }

    public String getDate(){
        return date;
    }

    public void displayDate(){
        dateLabel.setText(date);
        dateLabel.setAlignment(Pos.CENTER);
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

    //switches to the create event page
    public void addNewEvent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CreateEvent.fxml"));


        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void viewEvent(ActionEvent e){
        eventToView.setText("Event viewed!");
    }

    public void listEventsAvailableForDay(){
        System.out.println("called the method");
        System.out.println(date);
        displayCurrentEvents.setText("");
        if (!CalendarLogic.hasEvents(date)){
            displayCurrentEvents.setText("No event available for this date yet");
        } else {
            ArrayList<Event> dayEventList = CalendarLogic.getListOfEvents(date);
            for (int i = 1; i < dayEventList.size(); i ++){
                displayCurrentEvents.appendText(i + ". " + dayEventList.get(i).getTitle() + "\n");
            }
        }
    }


}
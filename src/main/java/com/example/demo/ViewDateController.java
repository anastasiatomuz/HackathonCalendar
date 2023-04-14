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

    //constructor
    public ViewDateController(){
        displayCurrentEvents = new TextArea();
        date = "";
        listEventsAvailableForDay();
    }

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
        Parent root = fxmlLoader.load();
        CreateEventController createEventController = fxmlLoader.getController();
        createEventController.addDate(date);
        createEventController.displayDate();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewEvent(ActionEvent e) throws IOException {
        Event theEvent = new Event();
        int eventChosenNum = Integer.parseInt(eventToView.getText()) - 1;
        for (int i = 0; i < CalendarLogic.getListOfEvents(date).size(); i++){
            if (eventChosenNum == i){
                theEvent = CalendarLogic.getListOfEvents(date).get(i);
            } 
        }
        
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ViewEvent.fxml"));
        Parent root = fxmlLoader.load();
        
        ViewEventController viewEventController = fxmlLoader.getController();
        viewEventController.setDate(date);
        viewEventController.setEvent(theEvent);
        viewEventController.displayEventInfo();
      
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void listEventsAvailableForDay(){
        System.out.println("called the method");
        System.out.println(date);
        displayCurrentEvents.setText("");
        if (!CalendarLogic.hasEvents(date)){
            displayCurrentEvents.setText("No event available for this date yet");
        } else {
            ArrayList<Event> dayEventList = CalendarLogic.getListOfEvents(date);
            for (int i = 0; i < dayEventList.size(); i ++){
                displayCurrentEvents.appendText((i + 1) + ". " + dayEventList.get(i).getTitle() + "\n");
            }
        }
    }


}
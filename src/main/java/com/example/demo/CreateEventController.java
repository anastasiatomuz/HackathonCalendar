package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CreateEventController {

    @FXML
    TextField peterPan; //title
    @FXML
    RadioButton captainHook; //radio
    @FXML
    TextField spongeBob; //start
    @FXML
    TextField patrick; //end
    @FXML
    TextArea sofiaTheFirst; //info

    @FXML
    private Label dateLabel;
    private Stage stage;
    private Scene scene;
    private WelcomePageController welcomePageController;
    private ViewDateController viewDateController;
    private CalendarLogic calendarLogic;
    private Parent root;
    private String date;

    //constructor
    public CreateEventController (){
        date = "";
    }

    public void addDate(String dateToAdd){
        date = dateToAdd;
    }

    public void switchBack(ActionEvent e) throws IOException {
        welcomePageController = new WelcomePageController();
        viewDateController = new ViewDateController();
        welcomePageController.switchToApp(e);
        viewDateController.listEventsAvailableForDay();
    }

    public void displayDate(){
        dateLabel.setText(date);
    }

    public void addComplete(ActionEvent e) throws IOException {

        String title = peterPan.getText();
        boolean allDay = captainHook.isDisabled();
        String start = spongeBob.getText();
        String end = patrick.getText();
        String info = sofiaTheFirst.getText();


        Event newEvent = new Event();
        //add the info about the day to the event object
        newEvent.setTitle(title);
        newEvent.setAllDay(allDay);
        newEvent.setStartTime(start);
        newEvent.setEndTime(end);
        newEvent.setInfo(info);

        //adds event to the hashmap
        if (!CalendarLogic.hasEvents(date)) {
            CalendarLogic.addFirstEvent(date, newEvent);
        } else {
            CalendarLogic.addEventToDay(date, newEvent);
        }


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
}

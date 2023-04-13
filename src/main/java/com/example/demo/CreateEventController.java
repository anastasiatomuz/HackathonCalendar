package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateEventController {
    @FXML
    private Label dateLabel;
    private Stage stage;
    private Scene scene;
    private WelcomePageController welcomePageController;
    private ViewDateController viewDateController;
    private CalendarLogic calendarLogic;

    @FXML
    private TextField titleField;
    @FXML
    private RadioButton radioButton;
    @FXML
    private TextField startTimeField;
    @FXML
    private TextField endTimeField;
    @FXML
    private TextArea infoArea;



    public void switchBack(ActionEvent e) throws IOException {
        welcomePageController = new WelcomePageController();
        viewDateController = new ViewDateController();
        welcomePageController.switchToApp(e);
        viewDateController.listEventsAvailableForDay();
    }

    public void displayDate(String date){
        dateLabel.setText(date);
    }

    public void addComplete(ActionEvent e) {
        //viewDateController = new ViewDateController();

        String currentDate = "4/13/2023";

        Event newEvent = new Event();
        String title = titleField.getText();
        System.out.println(title);
        boolean allDay = radioButton.isDisabled();
        String start = startTimeField.getText();
        String end = endTimeField.getText();
        String info = infoArea.getText();

        //add the info about the day to the event object
        newEvent.setTitle(title);
        newEvent.setAllDay(allDay);
        newEvent.setStartTime(start);
        newEvent.setEndTime(end);
        newEvent.setInfo(info);

        if (!CalendarLogic.hasEvents(currentDate)) {
            CalendarLogic.addFirstEvent(currentDate, newEvent);
        } else {
            CalendarLogic.addEventToDay(currentDate, newEvent);
        }
    }
}

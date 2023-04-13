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
    Label dateLabel;
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



    public void switchBack(ActionEvent e) throws IOException{
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

        calendarLogic.createEvent();
        calendarLogic.getCalendarEvent().setTitle(title);
        calendarLogic.getCalendarEvent().setAllDay(allDay);
        calendarLogic.getCalendarEvent().setStartTime(start);
        calendarLogic.getCalendarEvent().setEndTime(end);
        calendarLogic.getCalendarEvent().setInfo(info);


        calendarLogic.addToList();
        calendarLogic.addToHashMap(welcomePageController.getFormattedDate(), calendarLogic.getEventsList());
    }


}

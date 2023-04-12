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
    }

    public void addComplete(ActionEvent e) throws IOException{
        String title = titleField.getText();
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

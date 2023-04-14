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
    TextField peterPan;
    @FXML
    Label labelForTitle;
    @FXML
    Label label;
    @FXML
    TextField textField;
    @FXML
    Button button;
    @FXML
    private Label dateLabel;
    private Stage stage;
    private Scene scene;
    private WelcomePageController welcomePageController;
    private ViewDateController viewDateController;
    private CalendarLogic calendarLogic;
    private Parent root;

//    @FXML
//    TextField titleField;
    @FXML
    RadioButton radioButton;
    @FXML
    RadioButton radioButton2;
    @FXML
    TextField startTimeField;
    @FXML
    TextField endTimeField;
    @FXML
    TextArea infoArea;

    @FXML
    Button addEventButton;

    private String title;

    //constructor
    public CreateEventController (){
//        titleField = new TextField();
        radioButton = new RadioButton();
        radioButton2 = new RadioButton();
        startTimeField = new TextField();
        endTimeField = new TextField();
        infoArea = new TextArea();
        title = "";

    }


    public void switchBack(ActionEvent e) throws IOException {
        welcomePageController = new WelcomePageController();
        viewDateController = new ViewDateController();
        welcomePageController.switchToApp(e);
        viewDateController.listEventsAvailableForDay();
    }

    public void displayDate(String date){
        dateLabel.setText(date);
    }

    public void addComplete(ActionEvent e) throws IOException {
        //viewDateController = new ViewDateController();
        System.out.println("ahhhhhhhhhhh");
        String currentDate = "4/13/2023";

        String title = peterPan.getText();
        boolean allDay = radioButton.isDisabled();
        String start = startTimeField.getText();
        String end = endTimeField.getText();
        String info = infoArea.getText();

        System.out.println(title);
        System.out.println(allDay);
        System.out.println(start);
        System.out.println(end);
        System.out.println(info);



        Event newEvent = new Event();
        //add the info about the day to the event object
        newEvent.setTitle(title);
        newEvent.setAllDay(allDay);
        newEvent.setStartTime(start);
        newEvent.setEndTime(end);
        newEvent.setInfo(info);

        //adds event to the hashmap
        if (!CalendarLogic.hasEvents(currentDate)) {
            CalendarLogic.addFirstEvent(currentDate, newEvent);
        } else {
            CalendarLogic.addEventToDay(currentDate, newEvent);
        }

        ArrayList<Event> list = CalendarLogic.getListOfEvents(currentDate);
        for (Event event : list){
            System.out.println(event);
            System.out.println(event.getTitle());
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewDate.fxml"));
        root = fxmlLoader.load();

        viewDateController = fxmlLoader.getController();

        //set the date for the view date window
        viewDateController.setDate(currentDate);
        viewDateController.displayDate();
        viewDateController.listEventsAvailableForDay();

        //load the scene/window
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        welcomePageController.switchToApp(e);

    }

    public void myMethod(ActionEvent e) throws IOException{
        String words = textField.getText();
        System.out.println(words);
        label.setText(words);
    }

    public void setNewTitle(ActionEvent e) throws IOException{
        title = peterPan.getText();
        System.out.println(title);
        labelForTitle.setText(title);
    }
}

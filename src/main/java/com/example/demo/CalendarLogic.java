package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class CalendarLogic {

    //instance variables
    private Event calendarEvent;
    private ArrayList<Event> eventsList;
    private HashMap<String, ArrayList<Event>> calendarList;

    //constructor
    public CalendarLogic(){
        calendarEvent = null;
        eventsList = new ArrayList<>();
        calendarList = new HashMap<>();
    }

    public void addEvent(String title, boolean allDay, String startTime, String endTime, String info){
        Event newEvent = new Event(title, allDay, startTime, endTime, info);
        eventsList.add(newEvent);
    }

    //adding keys and values to HashMaps
    public void addToHashMap(String date, ArrayList<Event> list){
        calendarList.put(date, list);
    }
}

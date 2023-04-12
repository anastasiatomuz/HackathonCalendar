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

    //getter and setter methods
    public ArrayList<Event> getEventsList(){
        return eventsList;
    }

    public Event getCalendarEvent(){
        return calendarEvent;
    }

    public void createEvent(){
        calendarEvent = new Event();

    }

    public void addToList(){
        eventsList.add(calendarEvent);
    }

    //adding keys and values to HashMaps
    public void addToHashMap(String date, ArrayList<Event> list){
        calendarList.put(date, list);
    }
}

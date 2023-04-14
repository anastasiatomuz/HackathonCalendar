package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class CalendarLogic {


    private static HashMap<String, ArrayList<Event>> calendarList = new HashMap<>();

    //getter and setter methods
    public static ArrayList<Event> getListOfEvents(String date){
        return calendarList.get(date);
    }

    //adds an event to the day
    //precondition: day already has at least one event
    public static void addEventToDay(String date, Event eventToAdd){
        ArrayList<Event> dayEvents = calendarList.get(date);
        dayEvents.add(eventToAdd);
        calendarList.replace(date, dayEvents);
    }

    //returns if the day has any events yet
    public static boolean hasEvents(String date){
        return calendarList.containsKey(date);
    }

    //to be used only for the first event we add to the day
    public static void addFirstEvent(String date, Event firstEvent){
        ArrayList<Event> dayEvents = new ArrayList<>();
        dayEvents.add(firstEvent);
        calendarList.put(date, dayEvents);
    }
}
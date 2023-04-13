package com.example.demo;

public class Event {
    //instance variables
    private String title;
    private boolean allDay;
    private String info;
    private String startTime;
    private String endTime;

    //constructor
    public Event(){
        title = "Blank";
        allDay = false;
        startTime = "unknown";
        endTime = "unknown";
        info = "n/a";
    }

    //getter and setter methods
    public String getTitle(){
        return title;
    }

    public boolean isAllDay(){
        return allDay;
    }

    public String getStartTime(){
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public String getInfo(){
        return info;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

    public void setAllDay(boolean updatedAllDay){
        allDay = updatedAllDay;
    }

    public void setStartTime(String start){
        startTime = start;
    }

    public void setEndTime(String end){
        endTime = end;
    }

    public void setInfo(String newInfo){
        info = newInfo;
    }

}

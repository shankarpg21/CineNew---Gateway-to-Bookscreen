package com.example.MovieTicketBooking.shows;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowDTO {
    private String name,info;

    private LocalDate date;

    private LocalTime time;

    private int screenNo;

    public ShowDTO() {}

    public ShowDTO(String name,String info, LocalDate date, LocalTime time, int screenNo) {
        this.name = name;
        this.info=info;
        this.date = date;
        this.time = time;
        this.screenNo = screenNo;
    }

    public String getName(){
        return name;
    }
    public String getInfo(){
        return info;
    }
    public LocalDate getDate(){
        return date;
    } 
    public LocalTime getTime(){
        return time;
    }
    public int getScreen(){
        return screenNo;
    }
}

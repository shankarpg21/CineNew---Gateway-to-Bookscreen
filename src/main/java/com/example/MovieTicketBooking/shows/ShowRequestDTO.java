package com.example.MovieTicketBooking.shows;

import java.time.LocalDate;
import java.time.LocalTime;


public class ShowRequestDTO {
    private long id;

    private LocalDate date;

    private LocalTime time;

    private int screenNo;

    public ShowRequestDTO() {}

    public ShowRequestDTO(Long id, LocalDate date, LocalTime time, int screenNo) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.screenNo = screenNo;
    }

    public long getId(){
        return id;
    }
    public LocalDate getDate(){
        return date;
    } 
    public LocalTime getTime(){
        return time;
    }
    public int getScreenNo(){
        return screenNo;
    }
}

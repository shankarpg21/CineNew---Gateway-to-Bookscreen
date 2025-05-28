package com.example.MovieTicketBooking.shows;

import com.example.MovieTicketBooking.movies.Movie;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;


    private LocalDate date;

    private LocalTime time;

    private int screenNo;

    public Show() {}

    public Show(Movie movie, LocalDate date, LocalTime time, int screenNo) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.screenNo = screenNo;
    }

    public Show(LocalDate date, LocalTime time, int screenNo) {
        this.date = date;
        this.time = time;
        this.screenNo = screenNo;
    }

    public Movie getMovie(){
        return movie;
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
    public long getShowId(){
        return showId;
    }
}
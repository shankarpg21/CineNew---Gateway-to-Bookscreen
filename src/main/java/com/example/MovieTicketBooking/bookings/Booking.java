package com.example.MovieTicketBooking.bookings;


import com.example.MovieTicketBooking.shows.Show;
import com.example.MovieTicketBooking.users.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    
    @ManyToOne
    @JoinColumn(name="show_id" ,nullable=false)
    private Show show;

    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    private String seats;

    public Booking(){

    }

    public Booking(Show show,User user,String seats){
        this.seats=seats;
        this.show=show;
        this.user=user;
    }

    public String getSeats(){
        return seats;
    }
    public Show getShow(){
        return show;
    }
    public User getUser(){
        return user;
    }

    public void setSeats(String seats){
        this.seats=seats;
    }

    public void setUser(User user){
        this.user=user;
    }
    
    public void setShow(Show show){
        this.show=show;
    }
}

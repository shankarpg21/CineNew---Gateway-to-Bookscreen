package com.example.MovieTicketBooking.bookings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingRequestDTO {
    @JsonProperty("user_id")
    private long user_id;

    @JsonProperty("show_id")
    private long show_id;
    private String[] seats;

    public long getUserId(){
        return user_id;
    }
    public long getShowId(){
        return show_id;
    }
    public String[] getSeats(){
        return seats;
    }

    public void setUserId(long user_id){
        this.user_id=user_id;
    }
    public void setShowId(long show_id){
        this.show_id=show_id;
    }
    public void setSeats(String[] seats){
        this.seats=seats;
    }
}

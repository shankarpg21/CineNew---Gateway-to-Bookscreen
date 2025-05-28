package com.example.MovieTicketBooking.shows;

public class UserRequestDTO {

    private long userId,showId;
    private String arr[];

    public UserRequestDTO(){

    }
    
    public UserRequestDTO(long userId,long showId,String arr[]){
        this.userId=userId;
        this.showId=showId;
        this.arr=arr;
    }

    public String[] getArr(){
        return arr;
    }

    public long getUserId(){
        return userId;
    }

    public long getShowId(){
        return showId;
    }
}

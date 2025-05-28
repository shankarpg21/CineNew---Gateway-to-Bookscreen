package com.example.MovieTicketBooking.movies;

public class MovieRequestDTO {
    private String name;
    
    private String info;

    public MovieRequestDTO(String name,String info){
        this.name=name;
        this.info=info;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setInfo(String info){
        this.info=info;
    }
    
    public String getName(){
        return name;
    }
    public String getInfo(){
        return info;
    }
}

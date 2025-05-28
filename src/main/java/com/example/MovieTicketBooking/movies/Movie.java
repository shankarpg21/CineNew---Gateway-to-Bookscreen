package com.example.MovieTicketBooking.movies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
    public Movie(){

    }
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private long id;
    private String name;
    
    private String info;
    public Movie(long id,String name,String info){
        this.id=id;
        this.name=name;
        this.info=info;
    }
    public Movie(String name,String info){
        this.name=name;
        this.info=info;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setInfo(String info){
        this.info=info;
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getInfo(){
        return info;
    }
}

 

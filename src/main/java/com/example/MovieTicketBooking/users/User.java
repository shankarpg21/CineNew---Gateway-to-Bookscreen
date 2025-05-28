package com.example.MovieTicketBooking.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private long id;
    private String email;
    private String passWord;

    User(){

    }
    
    public User(long id,String email,String passWord){
        this.id=id;
        this.email=email;
        this.passWord=passWord;
    }

    public long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getPassWord(){
        return passWord;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public void setPassword(String passWord){
        this.passWord=passWord;
    }

    public String toString(){
        return id+" "+email;
    }
}

package com.example.MovieTicketBooking.users;

public class UserRequestDTO {
    private long id;
    private String email;
    private String passWord;

    
    public long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
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

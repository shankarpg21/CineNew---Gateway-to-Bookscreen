package com.example.MovieTicketBooking.users;

public class UserDTO {
    private String email;

    public UserDTO() {}

    public UserDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

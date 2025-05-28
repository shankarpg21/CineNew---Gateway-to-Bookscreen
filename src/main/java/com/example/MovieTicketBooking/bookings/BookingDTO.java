package com.example.MovieTicketBooking.bookings;

import jakarta.annotation.sql.DataSourceDefinition;

public class BookingDTO {
    private Long bookingId;
    private String seats;
    private Long userId;

    public BookingDTO() { 
    }

    public BookingDTO(Long bookingId, String seats, Long userId) {
        this.bookingId = bookingId;
        this.seats = seats;
        this.userId = userId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getSeats() {
        return seats;
    }

    public Long getUserId() {
        return userId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

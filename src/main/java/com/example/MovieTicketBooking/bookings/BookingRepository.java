package com.example.MovieTicketBooking.bookings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT new com.example.MovieTicketBooking.bookings.BookingDTO(b.bookingId, b.seats, b.user.id) FROM Booking b WHERE b.show.showId = :showId")
    List<BookingDTO> findAllByShowId(@Param("showId") long showId);

    @Query("select b.seats from Booking b where b.show.showId=:showId")
    List<String> findSeatsByShowId(@Param("showId") long showId);

}

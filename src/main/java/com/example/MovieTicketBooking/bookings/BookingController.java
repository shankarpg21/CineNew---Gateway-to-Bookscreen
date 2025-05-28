package com.example.MovieTicketBooking.bookings;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping
    public ResponseEntity<String> bookShows(@RequestBody  BookingRequestDTO bookingRequestDTO) {
        return ResponseEntity.ok(bookingService.bookShows(bookingRequestDTO));
    }

    @GetMapping(path="{showId}")
    public ResponseEntity<List<BookingDTO>> getShowInfo(@PathVariable("showId") long show_id){
        return ResponseEntity.ok(bookingService.getShowInfo(show_id));
    }

    @DeleteMapping
    public ResponseEntity<String> cancelBookings(@RequestParam("bookingId") long bookingId){
        return ResponseEntity.ok(bookingService.cancelBookings(bookingId));
    }
}

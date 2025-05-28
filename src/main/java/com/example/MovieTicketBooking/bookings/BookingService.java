package com.example.MovieTicketBooking.bookings;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.MovieTicketBooking.shows.Show;
import com.example.MovieTicketBooking.shows.ShowRepository;
import com.example.MovieTicketBooking.users.User;
import com.example.MovieTicketBooking.users.UserRepository;

@Service
public class BookingService {
    
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    
    public BookingService(BookingRepository bookingRepository,ShowRepository showRepository,UserRepository userRepository){
        this.showRepository=showRepository;
        this.bookingRepository=bookingRepository;
        this.userRepository=userRepository;
    }
    public String bookShows(BookingRequestDTO bookingRequestDTO){
        System.out.println(bookingRequestDTO.getShowId()+" "+bookingRequestDTO.getUserId());
        Show show=showRepository.findById(bookingRequestDTO.getShowId()).orElseThrow(()->new IllegalArgumentException("Invalid showid"));
        User user=userRepository.findById(bookingRequestDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("Invalid user id"));
        String seats[]=bookingRequestDTO.getSeats();
        StringBuilder sb=new StringBuilder();
        for(String s:seats){
            sb.append(s);
            sb.append(",");
        }
        bookingRepository.save(new Booking(show,user,sb.toString()));
        return "Booking successfull";
    }

    public List<BookingDTO> getShowInfo(long show_id){
        return bookingRepository.findAllByShowId(show_id)
            .stream()
            .map(booking -> new BookingDTO(booking.getBookingId(), booking.getSeats(), booking.getUserId()))
            .collect(Collectors.toList());
    }

    public String cancelBookings(long bookingId){
        bookingRepository.deleteById(bookingId);
        return "Booking cancelled successful"; 
    }
}

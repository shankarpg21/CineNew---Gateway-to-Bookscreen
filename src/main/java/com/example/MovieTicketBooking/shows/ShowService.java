package com.example.MovieTicketBooking.shows;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.MovieTicketBooking.bookings.BookingRepository;
import com.example.MovieTicketBooking.movies.Movie;
import com.example.MovieTicketBooking.movies.MovieRepository;



@Service
public class ShowService {
    
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final BookingRepository bookingRepository;

    public ShowService(ShowRepository showRepository,MovieRepository movieRepository,BookingRepository bookingRepository){
        this.movieRepository=movieRepository;
        this.bookingRepository=bookingRepository; 
        this.showRepository=showRepository;
    }

    public void addShows(ShowRequestDTO showRequestDTO) {
        Movie movie=movieRepository.findById(showRequestDTO.getId()).orElseThrow(()->new IllegalArgumentException("Invalid movie id"));
        System.out.println(showRequestDTO.getScreenNo());
        showRepository.save(new Show(movie,showRequestDTO.getDate(),showRequestDTO.getTime(),showRequestDTO.getScreenNo()));
    }

    public List<ShowDTO> getShows(){
        return showRepository.findAvlShows().stream().
        map(show->new ShowDTO(show.getName(),show.getInfo(),
         show.getDate(), show.getTime(),show.getScreen())).
        collect(Collectors.toList());
    }

    public String deleteShows(long showId){
        Optional<Show> show=showRepository.findById(showId);
        if(!show.isPresent()) return "Show does'nt exists";
        showRepository.deleteById(showId);
        return "Show removed successfully";
    }

    public List<String> getSeats(long show_id){
        return bookingRepository.findSeatsByShowId(show_id);
    }
}

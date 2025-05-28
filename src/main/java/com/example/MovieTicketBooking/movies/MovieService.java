package com.example.MovieTicketBooking.movies;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class MovieService {

    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    public void addMovie(MovieRequestDTO movieReqDTO){
        Optional<Movie> opt=movieRepository.findByName(movieReqDTO.getName());
        if(opt.isPresent()){
            throw new IllegalStateException("Movie name already exists");
        }
        Movie newMovie=new Movie(movieReqDTO.getName(),movieReqDTO.getInfo());
        movieRepository.save(newMovie);
    }
    
    public List<MovieDTO> getMovies() {
        return movieRepository.findAll().stream()
                .map(movie -> new MovieDTO(movie.getName(),movie.getInfo())) 
                .collect(Collectors.toList());
    }
}

package com.example.MovieTicketBooking.movies;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }
    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDTO movieReqDTO){
        movieService.addMovie(movieReqDTO);
        return ResponseEntity.ok("Movie added succesfully");
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getMoviee(){
        return ResponseEntity.ok(movieService.getMovies());
    }
}

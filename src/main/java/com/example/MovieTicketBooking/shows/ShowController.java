package com.example.MovieTicketBooking.shows;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
    
    private final ShowService showService;

    public ShowController(ShowService showService){
        this.showService=showService;
    }

    @PostMapping
    public ResponseEntity<String> addShows(@RequestBody ShowRequestDTO showRequestDTO){
        showService.addShows(showRequestDTO);
        return ResponseEntity.ok("Movie added successfully");
    }

    @GetMapping
    public ResponseEntity<List<ShowDTO>> getShows(){
        return ResponseEntity.ok(showService.getShows());
    }
      
    @DeleteMapping(path="{showId}")
    public ResponseEntity<String> deleteShows(@PathVariable("showId") long showId){
        return ResponseEntity.ok(showService.deleteShows(showId));
    }

    @GetMapping(path = "{showId}")
    public ResponseEntity<List<String>>  getSeats(@PathVariable("showId") long showId){
        return ResponseEntity.ok(showService.getSeats(showId));
    }
}

package com.example.MovieTicketBooking.movies;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
    Optional<Movie> findByName(String name);
    
} 

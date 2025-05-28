package com.example.MovieTicketBooking.shows;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ShowRepository extends JpaRepository<Show,Long>{

    @Query("SELECT new com.example.MovieTicketBooking.shows.ShowDTO(m.name, m.info, s.date, s.time, s.screenNo) " +
       "FROM Show s LEFT JOIN s.movie m")
       List<ShowDTO> findAvlShows();

}

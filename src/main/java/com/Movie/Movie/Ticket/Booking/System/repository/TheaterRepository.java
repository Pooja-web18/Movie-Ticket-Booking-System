package com.Movie.Movie.Ticket.Booking.System.repository;


import com.Movie.Movie.Ticket.Booking.System.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}

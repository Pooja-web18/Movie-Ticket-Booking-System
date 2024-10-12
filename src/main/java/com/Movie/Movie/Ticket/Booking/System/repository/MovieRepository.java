package com.Movie.Movie.Ticket.Booking.System.repository;
import com.Movie.Movie.Ticket.Booking.System.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

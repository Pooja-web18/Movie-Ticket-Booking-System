package com.Movie.Movie.Ticket.Booking.System.repository;

import com.Movie.Movie.Ticket.Booking.System.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {

}

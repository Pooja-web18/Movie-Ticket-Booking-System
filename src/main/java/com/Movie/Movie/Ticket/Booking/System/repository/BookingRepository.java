package com.Movie.Movie.Ticket.Booking.System.repository;

import com.Movie.Movie.Ticket.Booking.System.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}

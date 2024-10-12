package com.Movie.Movie.Ticket.Booking.System.service;

import com.Movie.Movie.Ticket.Booking.System.model.Theater;

import java.util.List;

public interface TheaterService {
    Theater addTheater(Theater theater);
    List<Theater> getAllTheaters();
    Theater getTheaterById(Long id);
    Theater updateTheater(Long id, Theater theater);
    boolean deleteTheater(Long id);
}

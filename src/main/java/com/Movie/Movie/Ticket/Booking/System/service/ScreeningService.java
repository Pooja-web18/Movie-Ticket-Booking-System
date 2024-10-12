package com.Movie.Movie.Ticket.Booking.System.service;

import com.Movie.Movie.Ticket.Booking.System.model.Screening;

import java.util.List;

public interface ScreeningService {
    Screening addScreening(Screening screening);
    List<Screening> getAllScreenings();
    Screening getScreeningById(Long id);
    Screening updateScreening(Long id, Screening screening);
    void deleteScreening(Long id);
}

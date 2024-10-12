package com.Movie.Movie.Ticket.Booking.System.service;

import com.Movie.Movie.Ticket.Booking.System.model.Booking;

import java.util.List;

public interface BookingService {
    Booking addBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
}

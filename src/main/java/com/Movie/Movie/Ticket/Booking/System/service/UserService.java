package com.Movie.Movie.Ticket.Booking.System.service;

import com.Movie.Movie.Ticket.Booking.System.model.User;

public interface UserService {
    User registerUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}

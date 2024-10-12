package com.Movie.Movie.Ticket.Booking.System.repository;

import com.Movie.Movie.Ticket.Booking.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);
}

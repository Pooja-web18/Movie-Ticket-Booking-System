package com.Movie.Movie.Ticket.Booking.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Changed to lowercase for Java conventions

    private String title; // Changed to lowercase for Java conventions
    private String description; // Changed to lowercase for Java conventions

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Screening> screenings; // Updated to plural to indicate a list


}

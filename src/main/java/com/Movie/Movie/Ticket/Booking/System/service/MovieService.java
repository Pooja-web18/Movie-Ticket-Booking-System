package com.Movie.Movie.Ticket.Booking.System.service;

import com.Movie.Movie.Ticket.Booking.System.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    Movie addMovie(Movie movie);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovie(Long id);
}

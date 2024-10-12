package com.Movie.Movie.Ticket.Booking.System.service.serviceImpl;

import com.Movie.Movie.Ticket.Booking.System.model.Theater;
import com.Movie.Movie.Ticket.Booking.System.repository.TheaterRepository;
import com.Movie.Movie.Ticket.Booking.System.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    @Override
    public Theater updateTheater(Long id, Theater theater) {
        Theater existingTheater = theaterRepository.findById(id).orElse(null);
        if (existingTheater != null) {
            existingTheater.setName(theater.getName());
            return theaterRepository.save(existingTheater);
        }
        return null;
    }


    @Override
    public boolean deleteTheater(Long id) {
        theaterRepository.deleteById(id);
        return false;
    }
}

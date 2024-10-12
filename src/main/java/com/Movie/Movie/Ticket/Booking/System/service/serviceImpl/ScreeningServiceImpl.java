package com.Movie.Movie.Ticket.Booking.System.service.serviceImpl;

import com.Movie.Movie.Ticket.Booking.System.model.Screening;
import com.Movie.Movie.Ticket.Booking.System.repository.ScreeningRepository;
import com.Movie.Movie.Ticket.Booking.System.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;

    @Override
    public Screening addScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(Long id) {
        return screeningRepository.findById(id).orElse(null);
    }

    @Override
    public Screening updateScreening(Long id, Screening screening) {
        screening.setId(id);
        return screeningRepository.save(screening);
    }

    @Override
    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }
}

// ScreeningController.java
package com.Movie.Movie.Ticket.Booking.System.controller;

import com.Movie.Movie.Ticket.Booking.System.model.Screening;
import com.Movie.Movie.Ticket.Booking.System.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    @PostMapping
    public Screening addScreening(@RequestBody Screening screening) {
        return screeningService.addScreening(screening);
    }

    @GetMapping
    public List<Screening> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable Long id) {
        Screening screening = screeningService.getScreeningById(id);
        return screening != null ? ResponseEntity.ok(screening) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public Screening updateScreening(@PathVariable Long id, @RequestBody Screening screening) {
        return screeningService.updateScreening(id, screening);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
        return ResponseEntity.noContent().build();
    }
}

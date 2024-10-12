package com.Movie.Movie.Ticket.Booking.System.controller;

import com.Movie.Movie.Ticket.Booking.System.model.Theater;
import com.Movie.Movie.Ticket.Booking.System.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theater> addTheater(@RequestBody Theater theater) {
        Theater createdTheater = theaterService.addTheater(theater);
        return ResponseEntity.status(201).body(createdTheater);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<Theater>> getAllTheaters() {
        List<Theater> theaters = theaterService.getAllTheaters();
        return ResponseEntity.ok(theaters);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        Theater theater = theaterService.getTheaterById(id);
        return theater != null ? ResponseEntity.ok(theater) : ResponseEntity.notFound().build(); // Return 404 if not found
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater theater) {
        Theater updatedTheater = theaterService.updateTheater(id, theater);
        return updatedTheater != null ? ResponseEntity.ok(updatedTheater) : ResponseEntity.notFound().build(); // Return 404 if not found
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        if (theaterService.deleteTheater(id)) {
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }
}

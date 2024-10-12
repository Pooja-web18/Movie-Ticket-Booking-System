package com.Movie.Movie.Ticket.Booking.System.controller;

import com.Movie.Movie.Ticket.Booking.System.model.User;
import com.Movie.Movie.Ticket.Booking.System.repository.UserRepository;
import com.Movie.Movie.Ticket.Booking.System.security.jwt.JwtGeneratorFilter;
import com.Movie.Movie.Ticket.Booking.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtGeneratorFilter jwtGeneratorFilter;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {

//        user.setRole(user.getRole); // Set default role
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        userRepository.save(user);
//        return ResponseEntity.ok("User registered successfully");
//    }

        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully: " + registeredUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

//            String role = getRoleForUser(user.getUsername());
            String token = jwtGeneratorFilter.generateToken(authentication); // Generate token
            return ResponseEntity.ok("Login successful for user: " + user.getUsername() + ". Token: " + token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

//    private String getRoleForUser(String username) {
//        return username;
//    }

    @GetMapping("/users/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUser(@RequestParam(required = false) String username,
                                        @RequestParam(required = false) String email) {
        if (username != null) {
            User user = userService.findByUsername(username);
            return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
        } else if (email != null) {
            User user = userService.findByEmail(email);
            return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().body(null);
    }

}

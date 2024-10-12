package com.Movie.Movie.Ticket.Booking.System.service.serviceImpl;

import com.Movie.Movie.Ticket.Booking.System.model.User;
import com.Movie.Movie.Ticket.Booking.System.repository.UserRepository;
import com.Movie.Movie.Ticket.Booking.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       if(Objects.isNull(user.getRole())){
           user.setRole("ROLE_USER");
       }else {
           user.setRole("ROLE_ADMIN");
       }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}

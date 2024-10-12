package com.Movie.Movie.Ticket.Booking.System.security;
import com.Movie.Movie.Ticket.Booking.System.model.User;
import com.Movie.Movie.Ticket.Booking.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = userRepo.findByUsername(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("user not found with this email : "+username);
        }

        return new MyUserDetails(user);
    }
}
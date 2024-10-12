package com.Movie.Movie.Ticket.Booking.System.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Booking> booking;


}

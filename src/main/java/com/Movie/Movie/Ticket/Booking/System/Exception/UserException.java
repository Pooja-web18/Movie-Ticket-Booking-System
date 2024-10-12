package com.Movie.Movie.Ticket.Booking.System.Exception;

public class UserException extends RuntimeException{
    public UserException() {};
    public UserException(String message){
        super(message);
    }
}

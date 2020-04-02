package com.example.demo.controllers;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Film;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.findAllBookings();
    }

    @GetMapping("/bookings/{booking_id}")
    public Optional<Booking> getOneBooking(@PathVariable int booking_id){
        return bookingService.findOneBooking(booking_id);
    }

    @PostMapping("/bookings")
    public Booking createNewBooking(@RequestBody Booking booking) {
        return bookingService.addNewBooking(booking);
    }

}
package com.codeclan.courseservice.course_service.controllers;

import com.codeclan.courseservice.course_service.models.Booking;
import com.codeclan.courseservice.course_service.models.Customer;
import com.codeclan.courseservice.course_service.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/bookings/{id}")
    public ResponseEntity<Optional<Booking>> findBookingById(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK);
    }
    @PutMapping(value="/bookings/{id}")
    public ResponseEntity<Booking> updateCustomer(@RequestBody Booking booking, @PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.save(booking), HttpStatus.OK);
    }
    @DeleteMapping(value="/bookings/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping(value="/bookings/date")
    public ResponseEntity<List<Booking>> getBookingsByDate(@RequestParam(name="date") String date){
        return new ResponseEntity<>(bookingRepository.findByDate(LocalDate.parse(date)), HttpStatus.OK);
    }
}

package com.codeclan.courseservice.course_service.controllers;

import com.codeclan.courseservice.course_service.models.Course;
import com.codeclan.courseservice.course_service.models.Customer;
import com.codeclan.courseservice.course_service.repositories.CourseRepository;
import com.codeclan.courseservice.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/customers/{id}")
    public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value="/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
    }
    @PutMapping(value="/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
    }
    @DeleteMapping(value="/customers/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping(value="/customers/{id}/courses")
    public ResponseEntity<List<Course>> findCoursesForCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(value -> new ResponseEntity<>(courseRepository.findByBookingsCustomer(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND));
    }


}

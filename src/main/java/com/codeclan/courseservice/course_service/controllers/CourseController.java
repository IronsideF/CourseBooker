package com.codeclan.courseservice.course_service.controllers;

import com.codeclan.courseservice.course_service.models.Course;
import com.codeclan.courseservice.course_service.models.Customer;
import com.codeclan.courseservice.course_service.repositories.CourseRepository;
import com.codeclan.courseservice.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/courses/{id}")
    public ResponseEntity<Optional<Course>> findCourseById(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value="/courses/rating")
    public ResponseEntity<List<Course>> findCoursesByRating(@RequestParam(name="rating") double rating){
        return new ResponseEntity<>(courseRepository.findByStarRating(rating), HttpStatus.OK);
    }
    @PostMapping(value="/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);
    }

    @PutMapping(value="/course")
    public ResponseEntity<Course> updateCustomer(@RequestBody Course course, @PathVariable Long id){
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);
    }
    @DeleteMapping(value="/courses/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping(value="/courses/{id}/customers")
    public ResponseEntity<List<Customer>> findCustomersOnCourse(@PathVariable Long id,
                                                                @RequestParam(required=false, name="town") String town,
                                                                @RequestParam(required=false, name="age")Integer age){
        Optional<Course> course = courseRepository.findById(id);
                if (course.isPresent()){
                    if (town!=null&&age!=null){
                        return new ResponseEntity<>(customerRepository.findByTownAndAgeGreaterThanAndBookingsCourse(town, age, course.get()), HttpStatus.OK);
                    }
                    if (town!=null){
                        return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourse(town, course.get()), HttpStatus.OK);
                    } else { return new ResponseEntity<>(customerRepository.findByBookingsCourse(course.get()), HttpStatus.OK);}
                }
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }
//    @GetMapping(value="/courses/{id}/customers/town")
//    public ResponseEntity<List<Customer>> findCustomersByCourseAndTown(@PathVariable Long id, @RequestParam(name="town") String town){
//        Optional<Course> course = courseRepository.findById(id);
//        return course.map(value -> ).orElseGet(()-> new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND));
//    }
}

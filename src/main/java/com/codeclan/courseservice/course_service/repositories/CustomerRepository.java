package com.codeclan.courseservice.course_service.repositories;

import com.codeclan.courseservice.course_service.models.Course;
import com.codeclan.courseservice.course_service.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourse(Course course);
    List<Customer> findByTownAndBookingsCourse(String town, Course course);
    List<Customer> findByTownAndAgeGreaterThanAndBookingsCourse(String town, int age, Course course);
}

package com.codeclan.courseservice.course_service.repositories;

import com.codeclan.courseservice.course_service.models.Course;
import com.codeclan.courseservice.course_service.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStarRating(double rating);
    List<Course> findByBookingsCustomer(Customer customer);
}

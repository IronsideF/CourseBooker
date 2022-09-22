package com.codeclan.courseservice.course_service.components;

import com.codeclan.courseservice.course_service.models.Booking;
import com.codeclan.courseservice.course_service.models.Course;
import com.codeclan.courseservice.course_service.models.Customer;
import com.codeclan.courseservice.course_service.repositories.BookingRepository;
import com.codeclan.courseservice.course_service.repositories.CourseRepository;
import com.codeclan.courseservice.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course softwareCourse = new Course("Software Development", "Edinburgh", 4.5);
        courseRepository.save(softwareCourse);
        Course dataCourse = new Course("Data Analysis", "Glasgow", 4.3);
        courseRepository.save(dataCourse);
        Course teachingCourse = new Course("How to teach good", "Edinburgh", 5.0);
        courseRepository.save(teachingCourse);
        Course statisticalProgramming = new Course("Quantitative Methods and Reasoning", "Aberdeen", 3.7);
        courseRepository.save(statisticalProgramming);
        Customer keith = new Customer("Keith", "Edinburgh", 39);
        customerRepository.save(keith);
        Customer mar = new Customer("Mar", "Edinburgh", 29);
        customerRepository.save(mar);
        Customer ben = new Customer("Ben", "Glasgow", 17);
        customerRepository.save(ben);
        Customer sky = new Customer("Sky", "Remote", 105);
        customerRepository.save(sky);

        Booking booking1 = new Booking(LocalDate.of(2022, 8, 17), softwareCourse, mar);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking(LocalDate.of(2021, 1, 6), dataCourse, sky);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking(LocalDate.of(2022, 3, 7), teachingCourse, ben);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking(LocalDate.of(1981, 12, 13), statisticalProgramming, keith);
        bookingRepository.save(booking4);
    }
}

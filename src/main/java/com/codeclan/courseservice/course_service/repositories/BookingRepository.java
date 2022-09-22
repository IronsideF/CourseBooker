package com.codeclan.courseservice.course_service.repositories;

import com.codeclan.courseservice.course_service.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(LocalDate localDate);
}

package com.codeclan.courseservice.course_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    @JsonIgnoreProperties({"bookings"})
    private Course course;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    @JsonIgnoreProperties({"bookings"})
    private Customer customer;

    public Booking() {
    }

    public Booking(LocalDate date, Course course, Customer customer) {
        this.date = date;
        this.course = course;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

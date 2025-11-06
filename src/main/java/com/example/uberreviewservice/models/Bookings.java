package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Bookings extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Review review;

    @Enumerated(value=EnumType.STRING)
    private BookingStatus bookingStatus; //HAS_A RELATION(COMPOSITION)

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;

    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;


}


/**
 * relation between Booking and review
 * 1 booking has one review and one review has one booking i.e. 1:1 relation>>>>
 *
 * now 1:M assocaitions
 *  a driver has many review but review belongs to a one driver
 *
 *
 */

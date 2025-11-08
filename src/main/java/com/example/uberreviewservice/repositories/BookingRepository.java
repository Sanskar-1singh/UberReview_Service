package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Bookings;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {

    List<Bookings> findAllByDriverId(long driverId);
    List<Review> findAllByReviewId(long reviewId);
    Bookings findById(long id);

    List<Bookings> findAllByDriverIn(List<Driver> driver);
}

package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Bookings;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {


     @Query(nativeQuery = true,value = "SELECT * FROM bookings b inner join booking_review r on b.review_id=:id")
      Review findReviewByBookingId(Long id);

}

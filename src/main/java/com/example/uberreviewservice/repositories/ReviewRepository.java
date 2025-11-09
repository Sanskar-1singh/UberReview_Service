package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Passenger;
import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query(nativeQuery = true,value="SELECT br.* FROM bookings b INNER JOIN booking_review br ON b.review_id = br.id WHERE b.id = :bookingI")
    Review findReviewByBookingId(Long bookingId);

}

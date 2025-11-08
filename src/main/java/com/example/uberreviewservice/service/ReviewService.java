package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Bookings;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.lang.Exception;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {


    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    private DriverRepository driverRepository;

    public ReviewService(@Qualifier("reviewRepository") ReviewRepository reviewRepository,
                         @Qualifier("bookingRepository") BookingRepository bookingRepository,
                         @Qualifier("driverRepository") DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("************");

        Review review = Review.builder().content("amazing ride facility")
                .rating(5.0)
                .build();
      reviewRepository.save(review);

        List<Review> x = reviewRepository.findAll();
        System.out.println(x);
        reviewRepository.deleteById(1l);

        Optional<Driver> y = driverRepository.findById(1l);
        System.out.println(y);
          System.out.println("bye bye");
        Bookings b = bookingRepository.findById(1l);

        System.out.println(b);
//        List<Driver> d=driverRepository.findByIdAndLicencenumber(1l,"LIC1001");
//        System.out.println("hii"+d);
//
//        List<Bookings> bookings = bookingRepository.findAllByDriverId(1l);
//        System.out.println("hii evryone"+bookings);
//        for(Bookings b:bookings){
//            System.out.println("hii evryone"+b.getBookingStatus());
//        }


        Optional<Driver> z = driverRepository.rawfindByIdAndLicencenumber(1l,"LIC1001");





    }
}

/***
 * Eager loading and lazy loading
 *
 *
 * select d1_0.id,d1_0.created_at,d1_0.licencenumber,d1_0.name,d1_0.updated_at,
 * b1_0.driver_id,b1_0.id,b1_0.booking_status,b1_0.created_at,b1_0.end_time,p1_0.id,
 * p1_0.created_at,p1_0.name,p1_0.updated_at,r1_0.id,case when r1_1.id is not null then 1
 * when r1_2.driver_review_id is not null then 2 when r1_0.id is not null then 0 end,
 * r1_0.content,r1_0.created_at,r1_0.rating,r1_0.updated_at,r1_1.driver_review_content,
 * r1_2.passenger_rating,r1_2.passenger_review_content,b1_0.start_time,b1_0.total_distance,
 * b1_0.updated_at from driver d1_0 left join bookings b1_0 on d1_0.id=b1_0.driver_id
 * left join passenger p1_0 on p1_0.id=b1_0.passenger_id
 * left join booking_review r1_0 on r1_0.id=b1_0.review_id
 * left join driver_review r1_1 on r1_0.id=r1_1.id left join passenger_review r1_2
 * on r1_0.id=r1_2.driver_review_id where d1_0.id=?
 */

/**
 * select b1_0.id,b1_0.booking_status,b1_0.created_at,b1_0.driver_id,b1_0.end_time,b1_0.passenger_id,
 * b1_0.review_id,b1_0.start_time,b1_0.total_distance,b1_0.updated_at from bookings b1_0
 * left join passenger p1_0 on p1_0.id=b1_0.passenger_id where p1_0.id=?
 */

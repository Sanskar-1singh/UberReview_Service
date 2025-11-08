package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Bookings;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.lang.Exception;
import java.util.*;

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
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("************");

//        Review review = Review.builder().content("amazing ride facility")
//                .rating(5.0)
//                .build();
//      reviewRepository.save(review);
//
//        List<Review> x = reviewRepository.findAll();
//        System.out.println(x);
//        reviewRepository.deleteById(1l);

//        Optional<Driver> y = driverRepository.findById(1l);
//        System.out.println(y);
//          System.out.println("bye bye");
//        Bookings b = bookingRepository.findById(1l);
//
//        System.out.println(b);
//        List<Driver> d=driverRepository.findByIdAndLicencenumber(1l,"LIC1001");
//        System.out.println("hii"+d);
//
//        List<Bookings> bookings = bookingRepository.findAllByDriverId(1l);
//        System.out.println("hii evryone"+bookings);
//        for(Bookings b:bookings){
//            System.out.println("hii evryone"+b.getBookingStatus());
//        }

//
//        Optional<Driver> z = driverRepository.rawfindByIdAndLicencenumber(1l,"LIC1001");

        List<Long> a=new ArrayList<>(Arrays.asList(1l,2l,3l,4l,5l));

        Driver d=driverRepository.findById(1l);
        System.out.println(d);

//        // one way to solve N+1 Problem>>
//        List<Bookings> bookings = bookingRepository.findAllByDriverIn(d);
//        System.out.println(bookings);
//     int cnt=0;
//        for(Driver driver:d){
//            List<Bookings> c=driver.getBookings();
//            c.forEach(booking->System.out.println(booking));
//        }
//
//

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
 *
 * focus on fetch mode it is very important>>>EAGER/LAZY
 *
 * LET DISCUSS N+1 PROBLEM>>>
 * to get data from DB for 1 query we make N+1 query>>>
 *
 *
 * we have an api which look liek somthing
 * GET-> /api/v1/drivers/bookings
 *
 * req_body:{
 *     driverId:[2,3,4,5,6]
 * }
 * executed response->we should be able to fetch drivers and bookings for each drivers
 *
 * W.R.T overall app performance,in drive model,bookings should be laod lazily
 * firstly we make 1 query to get all the driver id and then we will iterate on the driver list and make query to db to get
 * booking details again therefore for 1 query we are making again N query for booking therefore it is known as N+1 problem
 *
 * and if we do eager loading then it is harming our RAM which is also very bad>>>
 *  SOLUTION->
 *
 *  1.first make query to get all the driver list
 *  and then make query like (select * from booking where driver_id IN(1,2,3,....);
 *
 *  2. using JPA->
 *
 *
 *
 */

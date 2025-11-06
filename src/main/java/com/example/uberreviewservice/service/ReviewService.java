package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.lang.Exception;
import java.util.Date;

@Service
public class ReviewService implements CommandLineRunner {


    private ReviewRepository reviewRepository;

    public ReviewService(@Qualifier("reviewRepository") ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("************");

        Review review = Review.builder().content("amazing ride facility")
                .rating(5.0)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
      reviewRepository.save(review);
    }
}

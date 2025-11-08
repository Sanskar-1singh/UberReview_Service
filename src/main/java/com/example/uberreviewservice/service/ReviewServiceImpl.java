package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewServices{

      private ReviewRepository reviewRepository;

      public ReviewServiceImpl(@Qualifier("reviewRepository") ReviewRepository reviewRepository) {
          this.reviewRepository = reviewRepository;
      }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
                ;
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Boolean deleteReviewById(Long id) {

          try{
              reviewRepository.deleteById(id);
              return true;
          }
          catch(Exception e){
              return false;
          }

    }
}

package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             //<Entity_type,Primary_key_type>
public interface ReviewRepository extends JpaRepository<Review,Long> {



}

/**
 * database migrations or data versioning or schema versioning>>
 *
 */
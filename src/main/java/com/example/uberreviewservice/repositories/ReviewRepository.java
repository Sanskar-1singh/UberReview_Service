    package com.example.uberreviewservice.repositories;

    import com.example.uberreviewservice.models.Review;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    @Repository                                             //<Entity_type,Primary_key_type>
    public interface ReviewRepository extends JpaRepository<Review,Long> {

      Integer countAllByRatingIsLessThanEqual(Integer rating);

      List<Review> findAllByRatingIsLessThanEqual(Integer rating);

      List<Review> findAllByCreatedAtBefore(Date createdAt);

      Optional<Review> findById(Long id);

    }

    /**
     * database migrations or data versioning or schema versioning>>
     *
     */
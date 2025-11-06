package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {


}

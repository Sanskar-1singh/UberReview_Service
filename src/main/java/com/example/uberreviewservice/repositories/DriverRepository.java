package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    List<Driver> findByIdAndLicencenumber(Long id,String licencenumber);

    @Query(nativeQuery = true,value= "SELECT * FROM driver WHERE id=:id AND licencenumber=:licencenumber")
    Optional<Driver> rawfindByIdAndLicencenumber(Long id, String licencenumber);

}

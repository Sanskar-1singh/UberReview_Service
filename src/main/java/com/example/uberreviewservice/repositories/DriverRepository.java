package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    List<Driver> findByIdAndLicencenumber(Long id,String licencenumber);

    //any error at this query wil not detect at compile time but alway be get detct at run time and we have to test manually thsi query>>>
    @Query(nativeQuery = true,value= "SELECT * FROM driver WHERE id=:id AND licencenumber=:licencenumber")
    Optional<Driver> rawfindByIdAndLicencenumber(Long id, String licencenumber);

    List<Driver> findAllByIdIn(List<Long> ids);
    Driver findById(long id);


}

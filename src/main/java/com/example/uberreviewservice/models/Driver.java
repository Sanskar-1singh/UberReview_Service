package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{

    //DRIVER HAS MANY BOOKING 1:M

    private String name;

    @Column(nullable = false,unique = true)
    private String licencenumber;

    @OneToMany(mappedBy = "driver")
    private List<Bookings> bookings=new ArrayList<>();


}

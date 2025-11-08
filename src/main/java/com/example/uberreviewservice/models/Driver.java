package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class  Driver extends BaseModel{

    //DRIVER HAS MANY BOOKING 1:M

    private String name;

    @Column(nullable = false,unique = true)
    private String licencenumber;

    private String phoneNumber;

    private String aadharNumber;

    private String address;

    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    private List<Bookings> bookings;

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", licencenumber='" + licencenumber + '\'' +
                ", bookings=" +
                '}';
    }
}

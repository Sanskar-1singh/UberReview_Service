package com.example.uberreviewservice.models;

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
public class Passenger extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Bookings> bookings= new ArrayList<>();

}

/**
 * IN this project we have learnt about
 * 1-> DB associations
 * 2->Migrations
 * 3->lazy loading and eager loading
 * 4->n+1 problem
 * 5->inheritence in jpa
 * 6->jpa queries
 * 7->composition
 * 8-cascading in db
 * 9->entity creation in class format
 *
 *
 * 10->diffrent kind of annotations
 * 11->dependency injection
 * 12->about build system like gradle>>>
 *
 *
 */
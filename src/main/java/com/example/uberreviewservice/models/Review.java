package com.example.uberreviewservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id//this annotation makes the id property as primary key of my table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;




}

package com.example.uberreviewservice.dtos;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CreateReviewDtos {

    private String content;

    private Double rating;

    private Long bookingId;
}

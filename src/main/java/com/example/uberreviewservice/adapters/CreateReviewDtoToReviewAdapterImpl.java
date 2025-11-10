package com.example.uberreviewservice.adapters;

import com.example.uberreviewservice.dtos.CreateReviewDtos;
import com.example.uberreviewservice.dtos.CreateReviewDtos;
import com.example.uberreviewservice.models.Bookings;
import com.example.uberreviewservice.models.Bookings;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public Review convertDto(CreateReviewDtos createReviewDto) {
        //here we take optional because if booking comes out to be null in that case it will handle that>>>
        //we use ? wildcard to ensure that every kind of data can cames>>>
        Optional<Bookings> booking = bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value -> Review.builder()
                .rating(createReviewDto.getRating())
                .booking(value)
                .content(createReviewDto.getContent())
                .build()).orElse(null);
    }
}
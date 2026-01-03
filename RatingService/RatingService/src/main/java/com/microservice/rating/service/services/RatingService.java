package com.microservice.rating.service.services;

import java.util.List;

import com.microservice.rating.service.entities.Rating;

public interface RatingService {

    // create rating
    Rating createrating(Rating rating);

    // to get all rating
    List<Rating> getAllRating();

    // to get rating by userid
    List<Rating> getRatingByUserId(String userId);

    // to get rating by Hotelid
    List<Rating> getRatingByHotelId(String HotelId);
}

package com.microservice.rating.service.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import com.microservice.rating.service.entities.Hotel;
import com.microservice.rating.service.entities.Rating;
import com.microservice.rating.service.external.service.HotelService;
import com.microservice.rating.service.repositories.RatingRepo;
import com.microservice.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;

    // @Autowired
    // private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @SuppressWarnings("null")
    @Override
    public Rating createrating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {

        List<Rating> ratings = ratingRepo.findAll();

        for (Rating rating : ratings) {
            //Hotel hotels1 = restTemplate.getForObject("http://192.168.206.1:8082/hotels/"+ rating.getHotelId() , Hotel.class);
            Hotel hotels1 = hotelService.hotel(rating.getHotelId());
            rating.setHotels(List.of(hotels1));
        }
        return ratings;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelid) {
        List<Rating> ratings = ratingRepo.findByHotelId(hotelid);
         for (Rating rating : ratings) {
           // Hotel hotels1 = restTemplate.getForObject("http://192.168.206.1:8082/hotels/"+ rating.getHotelId() , Hotel.class);
            Hotel hotels1 = hotelService.hotel(rating.getHotelId());
            rating.setHotels(List.of(hotels1));
        }
        return ratings;
    }

    @Override
    public List<Rating> getRatingByUserId(String userid) {
        List<Rating> ratings = ratingRepo.findByUserId(userid);
         for (Rating rating : ratings) {
           // Hotel hotels1 = restTemplate.getForObject("http://192.168.206.1:8082/hotels/"+ rating.getHotelId() , Hotel.class);
            Hotel hotels1 = hotelService.hotel(rating.getHotelId());
            rating.setHotels(List.of(hotels1));
        }
        return ratings;
    }

}

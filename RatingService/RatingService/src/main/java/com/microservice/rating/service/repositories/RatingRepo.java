package com.microservice.rating.service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.rating.service.entities.Rating;

@Repository
public interface RatingRepo  extends MongoRepository<Rating,String>{

    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String hotelid);
}

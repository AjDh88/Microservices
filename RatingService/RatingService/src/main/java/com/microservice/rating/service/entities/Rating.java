package com.microservice.rating.service.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document("users_ratings")
public class Rating {

@Id
 private String ratingId;
 private String userId;
 private String hotelId;
 private int rating;
 private String feedback;

 @Transient
 private List<Hotel> hotels = new ArrayList<>();
}

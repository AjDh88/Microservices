package com.microservice.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

import com.microservice.user.service.entities.Rating;
import com.microservice.user.service.entities.User;
import com.microservice.user.service.exceptions.ResourceNotFoundException;
import com.microservice.user.service.external.service.RatingService;
import com.microservice.user.service.repositories.UserRepository;
import com.microservice.user.service.services.UserService;




@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private RestTemplate restTemplate;

    @Autowired
    private RatingService ratingService;
    
    // private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getAllUser() {
        
       List<User> user1 = userRepository.findAll();
       user1.forEach(user -> {
        //ArrayList<Rating> ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), ArrayList.class);
         Rating[] ratings1 = ratingService.rating(user.getUserId());
         ArrayList<Rating> ratings = new ArrayList<>(Arrays.asList(ratings1));
        user.setRatings(ratings);
    });
        
        return user1;
    }

   
    @Override
    public User getUser( String userId) {  
       User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("given user not found by userid: "+ userId));
      // ArrayList<Rating> arraayofratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), ArrayList.class);
      // logger.info("{}", arraayofratings);
      Rating[] ratings = ratingService.rating(userId);

      ArrayList<Rating> arraayofratings = new ArrayList<>(Arrays.asList(ratings));    
      user.setRatings(arraayofratings);
        return user;
    }

    @Override
    public User saveUser(User user) {
        String userid = UUID.randomUUID().toString();
        user.setUserId(userid);
        return userRepository.save(user);
    }

}

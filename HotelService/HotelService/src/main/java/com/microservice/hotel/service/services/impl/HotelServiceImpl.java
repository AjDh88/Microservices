
package com.microservice.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.service.entities.Hotel;
import com.microservice.hotel.service.exceptions.ResourceNotFoundException;
import com.microservice.hotel.service.repositories.HotelRepository;
import com.microservice.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @SuppressWarnings("null")
    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id is not found !!"));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

}

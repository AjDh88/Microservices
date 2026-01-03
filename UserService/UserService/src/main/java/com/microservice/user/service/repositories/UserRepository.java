package com.microservice.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.user.service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}

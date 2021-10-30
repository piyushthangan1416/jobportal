package com.jobportal.repositories;

import java.util.Optional;

import com.jobportal.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Caio Fernando
 */
@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    
    Optional <User> findByEmail(String email);
    
}
package com.jobportal.repositories;

import com.jobportal.entities.Job;
import com.jobportal.entities.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {

    UserProfile findByUserId(String userId);
}

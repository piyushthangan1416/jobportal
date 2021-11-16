package com.jobportal.repositories;


import com.jobportal.entities.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.jobportal.entities.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository  extends MongoRepository<Job,String> {
    List<Job> findByUserIdAndStatus(String userId,String status);

    List<Job> findByStatus(String status);
}

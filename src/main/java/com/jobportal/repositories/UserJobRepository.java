package com.jobportal.repositories;

import com.jobportal.entities.UserJob;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserJobRepository extends MongoRepository<UserJob,String> {
    List<UserJob> findByJobId(String id);

    List<UserJob> findByUserId(String id);
}

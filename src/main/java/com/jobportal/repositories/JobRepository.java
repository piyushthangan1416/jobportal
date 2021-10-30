package com.jobportal.repositories;

import com.jobportal.entities.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository  extends MongoRepository<Job,String> {

}

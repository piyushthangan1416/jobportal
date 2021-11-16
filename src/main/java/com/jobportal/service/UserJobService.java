package com.jobportal.service;

import com.jobportal.dto.JobDetailsDto;
import com.jobportal.entities.Job;
import com.jobportal.entities.UserJob;
import com.jobportal.repositories.JobRepository;
import com.jobportal.repositories.UserJobRepository;
import com.jobportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJobService {
    @Autowired
    private UserJobRepository userJobRepository;

    @Autowired
    private UserRepository userRepository;

    public void applyJob(String jobId, String email) {
        UserJob userJob = new UserJob();
        userJob.setUserId(userRepository.findByEmail(email).get().getId());
        userJob.setJobId(jobId);
        userJob.setStatus("Waiting");
        userJobRepository.save(userJob);
     }

    public void updateUserJob(String userJobId, String action) {
        UserJob userJob = userJobRepository.findById(userJobId).get();
        userJob.setStatus(action);
        userJobRepository.save(userJob);
    }
}

package com.jobportal.service;

import com.jobportal.dto.JobDetailsDto;
import com.jobportal.entities.Job;
import com.jobportal.entities.UserJob;
import com.jobportal.entities.UserProfile;
import com.jobportal.repositories.JobRepository;
import com.jobportal.repositories.UserJobRepository;
import com.jobportal.repositories.UserProfileRepository;
import com.jobportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJobRepository userJobRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public void saveJob(JobDetailsDto jobDetails, String emailId) {
        Job job=new Job();
        job.setCompanyName(jobDetails.getCompanyName());
        job.setEducation(jobDetails.getEducation());
        job.setJobType(jobDetails.getJobType());
        job.setEmail(jobDetails.getEmail());
        job.setCompanyDescription(jobDetails.getCompanyDescription());
        job.setExperience(jobDetails.getExperience());
        job.setEducation(jobDetails.getEducation());
        job.setLinkedIn(jobDetails.getLinkedIn());
        job.setJobDescription(jobDetails.getJobDescription());
        job.setLastdate(jobDetails.getLastdate());
        job.setSalary(jobDetails.getSalary());
        job.setWebsite(jobDetails.getWebsite());
        job.setSkills(jobDetails.getSkills());
        job.setLocation(jobDetails.getLocation());
        job.setJobTitles(jobDetails.getJobTitles());
        job.setUserId(userRepository.findByEmail(emailId).get().getId());
        job.setPostedDate(Instant.now());
        job.setStatus("Active");
        jobRepository.save(job);
     }

    public Object findAllJobs() {
       return jobRepository.findByStatus("Active");
    }

    public Object findById(String id) {
        return jobRepository.findById(id).get();
    }

    public Object findAllJobsByUserId(String emailId) {
        return jobRepository.findByUserIdAndStatus(userRepository.findByEmail(emailId).get().getId(),"Active");
    }

    public Object findUSerByJobId(String id) {
       List<UserJob> userJobs=userJobRepository.findByJobId(id);
       List<UserProfile> userProfiles=new ArrayList<UserProfile>();
        for (UserJob userJob: userJobs) {
            UserProfile userProfile = userProfileRepository.findByUserId(userJob.getUserId());
            userProfile.setStatus(userJob.getStatus());
            userProfile.setJobId(userJob.getJobId());
            userProfile.setUserJobId(userJob.getId());
            userProfiles.add(userProfile);
        }
        return userProfiles;
    }

    public void deleteJob(String jobId) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setStatus("Deleted");
            jobRepository.save(job);
            List<UserJob> userJobs=userJobRepository.findByJobId(jobId);
            for (UserJob userJob : userJobs){
                userJob.setStatus("Expired");
                userJobRepository.save(userJob);
            }
        }

    }
}

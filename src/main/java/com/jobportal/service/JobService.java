package com.jobportal.service;

import com.jobportal.dto.JobDetailsDto;
import com.jobportal.entities.Job;
import com.jobportal.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public void saveJob(JobDetailsDto jobDetails) {
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
        jobRepository.save(job);
     }
}

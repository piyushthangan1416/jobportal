package com.jobportal.service;

import com.jobportal.dto.UserJobDto;
import com.jobportal.dto.UserProfileDto;
import com.jobportal.entities.Job;
import com.jobportal.entities.User;
import com.jobportal.entities.UserJob;
import com.jobportal.entities.UserProfile;
import com.jobportal.repositories.JobRepository;
import com.jobportal.repositories.UserJobRepository;
import com.jobportal.repositories.UserProfileRepository;
import com.jobportal.repositories.UserRepository;
import com.jobportal.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserJobRepository userJobRepository;
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserService userService;
    public void saveUserProfile(UserProfileDto userProfileDto, String emailId)
    {
        UserProfile userProfile = findUserProfileByEmail(emailId);
        UserProfile profile= userProfile != null? userProfile: new UserProfile();
        profile.setUserId(userService.findByEmail(emailId).getId());
        profile.setAddress(userProfileDto.getAddress());
        profile.setEmail(emailId);
        profile.setAge(userProfileDto.getAge());
        profile.setName(userProfileDto.getName());
        profile.setDesignation(userProfileDto.getDesignation());
        profile.setDworkExperience1(userProfileDto.getDworkExperience1());
        profile.setDworkExperience2(userProfileDto.getDworkExperience2());
        profile.setDworkExperience3(userProfileDto.getDworkExperience3());
        profile.setWorkExperience1(userProfileDto.getWorkExperience1());
        profile.setWorkExperience2(userProfileDto.getWorkExperience2());
        profile.setWorkExperience3(userProfileDto.getWorkExperience3());
        profile.setPs1(userProfileDto.getPs1());
        profile.setPs2(userProfileDto.getPs2());
        profile.setPs3(userProfileDto.getPs3());
        profile.setPs4(userProfileDto.getPs4());
        profile.setPs5(userProfileDto.getPs5());
        profile.setPs6(userProfileDto.getPs6());
        profile.setClass12(userProfileDto.getClass12());
        profile.setClass12Details(userProfileDto.getClass12Details());
        profile.setClass12StartEnd(userProfileDto.getClass12StartEnd());
        profile.setClass10(userProfileDto.getClass10());
        profile.setClass10Details(userProfileDto.getClass10Details());
        profile.setClass10StartEnd(userProfileDto.getClass10StartEnd());
        profile.setGraduation(userProfileDto.getGraduation());
        profile.setGraduationDetails(userProfileDto.getGraduationDetails());
        profile.setGraduationStartEnd(userProfileDto.getGraduationStartEnd());
        profile.setPhone(userProfileDto.getPhone());
        profile.setAboutMe(userProfileDto.getAboutMe());
        FileUploadUtil.saveFile(userProfileDto.getProfilePhoto(),profile);
        FileUploadUtil.saveResumeFile(userProfileDto.getResume(),profile);
        userProfileRepository.save(profile);

    }

    public Object findById(String id) {
        return userProfileRepository.findByUserId(id);

    }

    public UserProfile findUserProfileByEmail(String emailId) {
       String id= userRepository.findByEmail(emailId).get().getId();
      return  userProfileRepository.findByUserId(id);

    }

    public Object findJobStatusByUser(String emailId) {
        User user=userRepository.findByEmail(emailId).get();
        List<UserJob> userJobsList =userJobRepository.findByUserId(user.getId());
        List<UserJobDto> userJobDtos=new ArrayList<>();
        for (UserJob userJob:userJobsList) {
            UserJobDto userJobDto=new UserJobDto();
            Optional<Job> jobOptional = jobRepository.findById(userJob.getJobId());
            if(jobOptional.isPresent()) {
                Job job = jobOptional.get();
                userJobDto.setCompanyName(job.getCompanyName());
                userJobDto.setStatus(userJob.getStatus());
                userJobDto.setDesignation(job.getJobTitles());
                userJobDto.setPostedDate(job.getPostedDate().toString());
                userJobDto.setAppliedDate(userJob.getApplliedDate().toString());
                userJobDto.setJobId(job.getId());
                userJobDto.setUserJobId(userJob.getId());
                userJobDto.setUserId(userJob.getUserId());
                userJobDtos.add(userJobDto);
            }
        }
        return userJobDtos;


    }
}

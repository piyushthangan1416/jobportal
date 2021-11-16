package com.jobportal.service;

import com.jobportal.dto.ReviewDto;
import com.jobportal.entities.Review;
import com.jobportal.entities.User;
import com.jobportal.repositories.ReviewRepository;
import com.jobportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    public void saveReview(ReviewDto reviewDto){
        Review review =new Review();
        review.setCompanyReview(reviewDto.getCompanyReview());
        review.setDesignation(reviewDto.getDesignation());
        review.setJobReview(reviewDto.getJobReview());
        review.setLocation(reviewDto.getLocation());
        review.setExperience(reviewDto.getExperience());
        review.setInterview(reviewDto.getInterview());
        review.setCompanyName(reviewDto.getCompanyName());
        review.setSalaryDescription(reviewDto.getSalaryDescription());
       User user= userRepository.findByEmail(reviewDto.getUserId()).get();
        review.setUserId(user.getId());
        review.setUsername(user.getName());
        reviewRepository.save(review);

    }
    public Object findAllReview() {
        return reviewRepository.findAll();
    }

    public Object findById(String id) {
        return reviewRepository.findById(id).get();
    }

}

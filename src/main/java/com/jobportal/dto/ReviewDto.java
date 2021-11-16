package com.jobportal.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ReviewDto {
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String location;
    @NotEmpty
    private String designation;
    @NotEmpty
    private String experience;
    @NotEmpty
    private String companyReview;
    @NotEmpty
    private String jobReview;
    @NotEmpty
    private String salaryDescription;
    @NotEmpty
    private String interview;


    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCompanyReview() {
        return companyReview;
    }

    public void setCompanyReview(String companyReview) {
        this.companyReview = companyReview;
    }

    public String getJobReview() {
        return jobReview;
    }

    public void setJobReview(String jobReview) {
        this.jobReview = jobReview;
    }

    public String getSalaryDescription() {
        return salaryDescription;
    }

    public void setSalaryDescription(String salaryDescription) {
        this.salaryDescription = salaryDescription;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }
}

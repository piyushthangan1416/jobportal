package com.jobportal.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class JobDetailsDto {
    @NotEmpty
    private String jobTitles;
    @NotEmpty
    private String location;
    @NotEmpty
    private String email;
    @NotEmpty
    private String lastdate;
    @NotEmpty
    private String experience;
    @NotEmpty
    private String jobType;
    @NotEmpty
    private String jobDescription;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String salary;
    @NotEmpty
    private String companyDescription;
    @NotEmpty
    private String website;
    @NotEmpty
    private String skills;
    @NotEmpty
    private String education;
    @NotEmpty
    private String linkedIn;

    public String getJobTitles() {
        return jobTitles;
    }

    public void setJobTitles(String jobTitles) {
        this.jobTitles = jobTitles;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    @Override
    public String toString() {
        return "JobDetailsDto{" +
                "jobTitles='" + jobTitles + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", experience='" + experience + '\'' +
                ", jobType='" + jobType + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}


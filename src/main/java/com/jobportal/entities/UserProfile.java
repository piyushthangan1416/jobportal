package com.jobportal.entities;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "JOB")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String Designation;
    @NotEmpty
    private String age;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotEmpty
    private String ps1;
    @NotEmpty
    private String ps2;
    @NotEmpty
    private String ps3;
    @NotEmpty
    private String ps4;
    @NotEmpty
    private String ps5;
    @NotEmpty
    private String ps6;
    @NotEmpty
    private String workExperience1;
    @NotEmpty
    private String dworkExperience1;
    @NotEmpty
    private String workExperience2;
    @NotEmpty
    private String dworkExperience2;
    @NotEmpty
    private String workExperience3;
    @NotEmpty
    private String dworkExperience3;
    @NotEmpty
    private String graduation;
    @NotEmpty
    private String graduationDetails;
    @NotEmpty
    private String graduationStartEnd;
    @NotEmpty
    private String class12;
    @NotEmpty
    private String class12Details;
    @NotEmpty
    private String class12StartEnd;
    @NotEmpty
    private String class10;
    @NotEmpty
    private String class10Details;
    @NotEmpty
    private String class10StartEnd;
    @NotEmpty
    private String aboutMe;

    @Column(unique = true)
    private String userId;

    private String profilePhotoPath;

    private String profilePhoto;

    private String profilePhotoFileName;

    private String resumePath;

    private String resumeFileName;

    @Transient
    private String status;

    private String jobId;

    private String userJobId;

    private String resume;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProfilePhoto() {
        return profilePhotoFileName;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhotoFileName;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getUserJobId() {
        return userJobId;
    }

    public void setUserJobId(String userJobId) {
        this.userJobId = userJobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getProfilePhotoFileName() {
        return profilePhotoFileName;
    }

    public void setProfilePhotoFileName(String profilePhotoFileName) {
        this.profilePhotoFileName = profilePhotoFileName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPs1() {
        return ps1;
    }

    public void setPs1(String ps1) {
        this.ps1 = ps1;
    }

    public String getPs2() {
        return ps2;
    }

    public void setPs2(String ps2) {
        this.ps2 = ps2;
    }

    public String getPs3() {
        return ps3;
    }

    public void setPs3(String ps3) {
        this.ps3 = ps3;
    }

    public String getPs4() {
        return ps4;
    }

    public void setPs4(String ps4) {
        this.ps4 = ps4;
    }

    public String getPs5() {
        return ps5;
    }

    public void setPs5(String ps5) {
        this.ps5 = ps5;
    }

    public String getPs6() {
        return ps6;
    }

    public void setPs6(String ps6) {
        this.ps6 = ps6;
    }

    public String getWorkExperience1() {
        return workExperience1;
    }

    public void setWorkExperience1(String workExperience1) {
        this.workExperience1 = workExperience1;
    }

    public String getDworkExperience1() {
        return dworkExperience1;
    }

    public void setDworkExperience1(String dworkExperience1) {
        this.dworkExperience1 = dworkExperience1;
    }

    public String getWorkExperience2() {
        return workExperience2;
    }

    public void setWorkExperience2(String workExperience2) {
        this.workExperience2 = workExperience2;
    }

    public String getDworkExperience2() {
        return dworkExperience2;
    }

    public void setDworkExperience2(String dworkExperience2) {
        this.dworkExperience2 = dworkExperience2;
    }

    public String getWorkExperience3() {
        return workExperience3;
    }

    public void setWorkExperience3(String workExperience3) {
        this.workExperience3 = workExperience3;
    }

    public String getDworkExperience3() {
        return dworkExperience3;
    }

    public void setDworkExperience3(String dworkExperience3) {
        this.dworkExperience3 = dworkExperience3;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getGraduationDetails() {
        return graduationDetails;
    }

    public void setGraduationDetails(String graduationDetails) {
        this.graduationDetails = graduationDetails;
    }

    public String getGraduationStartEnd() {
        return graduationStartEnd;
    }

    public void setGraduationStartEnd(String graduationStartEnd) {
        this.graduationStartEnd = graduationStartEnd;
    }

    public String getClass12() {
        return class12;
    }

    public void setClass12(String class12) {
        this.class12 = class12;
    }

    public String getClass12Details() {
        return class12Details;
    }

    public void setClass12Details(String class12Details) {
        this.class12Details = class12Details;
    }

    public String getClass12StartEnd() {
        return class12StartEnd;
    }

    public void setClass12StartEnd(String class12StartEnd) {
        this.class12StartEnd = class12StartEnd;
    }

    public String getClass10() {
        return class10;
    }

    public void setClass10(String class10) {
        this.class10 = class10;
    }

    public String getClass10Details() {
        return class10Details;
    }

    public void setClass10Details(String class10Details) {
        this.class10Details = class10Details;
    }

    public String getClass10StartEnd() {
        return class10StartEnd;
    }

    public void setClass10StartEnd(String class10StartEnd) {
        this.class10StartEnd = class10StartEnd;
    }

    public String getAboutMe() {return aboutMe;}

    public void setAboutMe(String aboutMe) {this.aboutMe = aboutMe;}

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", Designation='" + Designation + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

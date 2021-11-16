package com.jobportal.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

/**
 *
 */

 @Entity
 @Table(name = "USER_JOB")
public class UserJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    @NotEmpty()
    private String jobId;

    @Column(nullable = false,unique = true)
    @NotEmpty
    private String userId;

    private Instant applliedDate= Instant.now();

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Instant getApplliedDate() {
        return applliedDate;
    }

    public void setApplliedDate(Instant applliedDate) {
        this.applliedDate = applliedDate;
    }
}

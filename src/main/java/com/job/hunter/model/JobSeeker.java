package com.job.hunter.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class JobSeeker extends User {

    @OneToMany(targetEntity = AppliedJob.class, mappedBy = "jobSeeker")
    private List<AppliedJob> appliedJobs;

    public JobSeeker() {
        super();
    }

    public JobSeeker(String userName, String email, String password) {
       super(userName, email, password);
    }

    public List<AppliedJob> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<AppliedJob> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}

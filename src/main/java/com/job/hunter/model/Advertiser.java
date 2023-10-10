package com.job.hunter.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Advertiser extends User {

    @OneToMany(targetEntity = Job.class, mappedBy = "advertiser")
    private List<Job> jobs;

    public Advertiser() {
        super();
    }

    public Advertiser(String userName, String email, String password) {
        super(userName, email, password);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}


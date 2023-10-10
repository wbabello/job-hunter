package com.job.hunter.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {

    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "location")
    private String location;

    @Column(name = "type")
    private String type;

    @Column(name = "published_date")
    private Long publishedDate;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private String salary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Advertiser advertiser;

    @OneToMany(targetEntity = AppliedJob.class, mappedBy = "job")
    private List<AppliedJob> appliedJobs;

    public Job() {
    }

    public Job(String title, String companyName, String location, String type, Long publishedDate, String status, String description, String salary, Advertiser advertiser) {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.type = type;
        this.publishedDate = publishedDate;
        this.status = status;
        this.description = description;
        this.salary = salary;
        this.advertiser = advertiser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public List<AppliedJob> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(List<AppliedJob> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}

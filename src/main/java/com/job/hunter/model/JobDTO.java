package com.job.hunter.model;

import com.job.hunter.utils.DateFormatUtils;

import java.util.List;

public class JobDTO {
    private Integer id;
    private String title;
    private String companyName;
    private String location;
    private String type;
    private String publishedDate;
    private String status;
    private String description;
    private String salary;

    public static JobDTO convert(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setCompanyName(job.getCompanyName());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setType(job.getType());
        jobDTO.setPublishedDate(DateFormatUtils.formatDate(job.getPublishedDate()));
        jobDTO.setStatus(job.getStatus());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setSalary(job.getSalary());
        return jobDTO;
    }

    public static List<JobDTO> convert(List<Job> guestTable) {
        return guestTable.stream()
                .map(JobDTO::convert)
                .toList();
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
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
}

package com.job.hunter.service;

import com.job.hunter.dao.AppliedJobRepository;
import com.job.hunter.dao.JobRepository;
import com.job.hunter.dao.JobSeekerRepository;
import com.job.hunter.model.*;
import com.job.hunter.utils.AppConstants;
import com.job.hunter.utils.SessionUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.job.hunter.utils.AppConstants.*;
import static com.job.hunter.utils.AppConstants.JSPFile.JOB_DETAILS_PAGE;
import static com.job.hunter.utils.AppConstants.JSPFile.JOB_SEEKER_HOME_PAGE;

@Service
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;
    private final JobRepository jobRepository;
    private final AppliedJobRepository appliedJobRepository;


    public JobSeekerService(JobSeekerRepository jobSeekerRepository, JobRepository jobRepository, AppliedJobRepository appliedJobRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
        this.jobRepository = jobRepository;
        this.appliedJobRepository = appliedJobRepository;
    }

    public String homePage(Query query, Model model, HttpServletRequest request) {
        if (isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        JobSeeker jobSeeker = fetchUserFromSession(request);
        String filterValue = query.getValue();
        List<Job> jobs;
        if (filterValue != null && !filterValue.isEmpty() && !filterValue.isBlank()) {
            jobs = jobRepository.findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseAndStatusNotIn(filterValue, filterValue);
        } else {
            jobs = jobRepository.findByStatusNotIn(List.of("Completed"));
        }
        List<Job> activeJobs = jobs.stream()
                .filter(it ->
                        it.getAppliedJobs()
                                .stream()
                                .noneMatch(appliedJob -> appliedJob.getJobSeeker().getId().equals(jobSeeker.getId())))
                .collect(Collectors.toList());

        List<JobDTO> jobsList = JobDTO.convert(activeJobs);
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(USER, jobSeeker);
        objectMap.put(JOB_LIST, jobsList);
        objectMap.put(QUERY, query);

        return JOB_SEEKER_HOME_PAGE;
    }

    public String jobDetailsHomePage(Integer id, Model model, HttpServletRequest request) {
        if (isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        JobDTO job = JobDTO.convert(jobRepository.findById(id).get());
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(JOB, job);
        objectMap.put(APPLIED_JOB, new AppliedJob());
        return JOB_DETAILS_PAGE;
    }

    public String applyJob(Integer id, AppliedJob appliedJob, Model model, HttpServletRequest request) {
        if (isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        Job job = jobRepository.findById(id).get();
        JobSeeker jobSeeker = fetchUserFromSession(request);
        appliedJob.setJob(job);
        appliedJob.setJobSeeker(jobSeeker);
        appliedJobRepository.save(appliedJob);

        return REDIRECT_JOB_SEEKERS;
    }

    private boolean isInValidSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        String type = SessionUtils.getCurrentUserType(request);
        return userId == null && !JOB_SEEKER.equals(type);
    }

    private JobSeeker fetchUserFromSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        return jobSeekerRepository.findById(userId).get();
    }
}

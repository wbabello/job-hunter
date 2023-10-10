package com.job.hunter.service;

import com.job.hunter.dao.AdvertiserRepository;
import com.job.hunter.dao.JobRepository;
import com.job.hunter.model.Advertiser;
import com.job.hunter.model.Job;
import com.job.hunter.model.JobDTO;
import com.job.hunter.utils.AppConstants;
import com.job.hunter.utils.SessionUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static com.job.hunter.utils.AppConstants.*;
import static com.job.hunter.utils.AppConstants.JSPFile.*;

@Service
public class AdvertiserService {

    private final AdvertiserRepository advertiserRepository;
    private final JobRepository jobRepository;

    public AdvertiserService(AdvertiserRepository advertiserRepository, JobRepository jobRepository) {
        this.advertiserRepository = advertiserRepository;
        this.jobRepository = jobRepository;
    }

    public String homePage(Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        Advertiser advertiser = fetchUserFromSession(request);
        List<JobDTO> jobsList = JobDTO.convert(jobRepository.findByAdvertiserAndStatusNotIn(advertiser, List.of("Completed")));
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(USER, advertiser);
        objectMap.put(JOB_LIST, jobsList);

        return ADVERTISER_HOME_PAGE;
    }

    public String jobHomePage(Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        Map<String, Object> objectMap = model.asMap();
        objectMap.put(JOB, new Job());
        return ADVERTISER_NEW_JOB;
    }

    public String createNewJob(Job job, Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        Advertiser advertiser = fetchUserFromSession(request);
        job.setAdvertiser(advertiser);
        job.setStatus("Active");
        job.setPublishedDate(Instant.now().toEpochMilli());
        // add validation here
        jobRepository.save(job);
        return REDIRECT_ADVERTISER;
    }

    public String editJobHomePage(Integer id, Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        Job job = jobRepository.findById(id).get();
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(JOB, job);
        return ADVERTISER_EDIT_JOB;
    }

    public String updateJob(Integer id, Job updatedJob, Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        Job job = jobRepository.findById(id).get();
        updatedJob.setId(id);
        updatedJob.setAdvertiser(job.getAdvertiser());
        updatedJob.setPublishedDate(job.getPublishedDate());
        jobRepository.save(updatedJob);
        return REDIRECT_ADVERTISER;
    }

    public String deleteJob(Integer id, Model model, HttpServletRequest request) {
        if(isInValidSession(request))
            return AppConstants.REDIRECT_HOME_PAGE;

        jobRepository.deleteById(id);
        return REDIRECT_ADVERTISER;
    }

    private boolean isInValidSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        String type = SessionUtils.getCurrentUserType(request);
        return userId == null && !ADVERTISER.equals(type);
    }

    private Advertiser fetchUserFromSession(HttpServletRequest request) {
        Integer userId = SessionUtils.getCurrentUserId(request);
        return advertiserRepository.findById(userId).get();
    }
}

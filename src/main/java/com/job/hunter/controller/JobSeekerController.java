package com.job.hunter.controller;

import com.job.hunter.model.AppliedJob;
import com.job.hunter.model.Query;
import com.job.hunter.service.JobSeekerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.job.hunter.utils.AppConstants.APPLIED_JOB;

@Controller
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;


    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/jobSeekers")
    public String homePage(@ModelAttribute("query") Query query, Model model, HttpServletRequest request) {
        return jobSeekerService.homePage(query, model, request);
    }

    @GetMapping("/jobSeekers/job/{id}/details")
    public String jobDetailsHomePage(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        return jobSeekerService.jobDetailsHomePage(id, model, request);
    }

    @PostMapping("/jobSeekers/job/{id}/apply")
    public String applyJob(@PathVariable("id") Integer id, @ModelAttribute(APPLIED_JOB) AppliedJob appliedJob, Model model, HttpServletRequest request) {
        return jobSeekerService.applyJob(id, appliedJob, model, request);
    }
}

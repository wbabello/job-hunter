package com.job.hunter.controller;

import com.job.hunter.model.Job;
import com.job.hunter.service.AdvertiserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import static com.job.hunter.utils.AppConstants.JOB;

@Controller
public class AdvertiserController {

    private final AdvertiserService advertiserService;

    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @GetMapping("/advertiser")
    public String homePage(Model model, HttpServletRequest request) {
        return advertiserService.homePage(model, request);
    }

    @GetMapping("/advertiser/job/new")
    public String jobHomePage(Model model, HttpServletRequest request) {
        return advertiserService.jobHomePage(model, request);
    }

    @PostMapping("/advertiser/job/new")
    public String createNewJob(@ModelAttribute(JOB)Job job, Model model, HttpServletRequest request) {
        return advertiserService.createNewJob(job, model, request);
    }

    @GetMapping("/advertiser/job/{id}/edit")
    public String editJobHomePage(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        return advertiserService.editJobHomePage(id, model, request);
    }

    @PostMapping("/advertiser/job/{id}/edit")
    public String updateJob(@PathVariable("id") Integer id, @ModelAttribute(JOB)Job job, Model model, HttpServletRequest request) {
        return advertiserService.updateJob(id, job, model, request);
    }

    @GetMapping("/advertiser/job/{id}/delete")
    public String deleteJob(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        return advertiserService.deleteJob(id, model, request);
    }
}

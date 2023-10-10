package com.job.hunter.controller;

import com.job.hunter.model.LoginUser;
import com.job.hunter.model.RegisterUser;
import com.job.hunter.service.AppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

import static com.job.hunter.utils.AppConstants.LOGIN_USER;
import static com.job.hunter.utils.AppConstants.REGISTER_USER;

@Controller
public class AppLoginController {
    private final AppLoginService appLoginService;

    @Autowired
    public AppLoginController(AppLoginService appLoginService) {
        this.appLoginService = appLoginService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return appLoginService.homePage(model);
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute(REGISTER_USER)RegisterUser registerUser, Model model, HttpServletRequest request) {
        return appLoginService.registerUser(registerUser, model, request);
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute(LOGIN_USER)LoginUser loginUser, Model model, HttpServletRequest request) {
        return appLoginService.loginUser(loginUser, model, request);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        return appLoginService.logout(request);
    }
}

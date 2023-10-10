package com.job.hunter.service;

import com.job.hunter.dao.AdvertiserRepository;
import com.job.hunter.dao.JobSeekerRepository;
import com.job.hunter.model.*;
import com.job.hunter.utils.AppConstants;
import com.job.hunter.utils.BCryptUtils;
import com.job.hunter.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.job.hunter.utils.AppConstants.*;

@Service
public class AppLoginService {
    private final AdvertiserRepository advertiserRepository;
    private final JobSeekerRepository jobSeekerRepository;

    @Autowired
    public AppLoginService(AdvertiserRepository advertiserRepository, JobSeekerRepository jobSeekerRepository) {
        this.advertiserRepository = advertiserRepository;
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public String homePage(Model model) {
        constructLoginDetails(model);
        return AppConstants.JSPFile.HOME_PAGE;
    }

    public String registerUser(RegisterUser registerUser, Model model, HttpServletRequest request) {
        if(!validateUserRegistration(registerUser, model)) {
            return  AppConstants.JSPFile.HOME_PAGE;
        }

        String password = registerUser.getPassword(); // plain english password
        String encodePassword = BCryptUtils.encodePassword(password); // encrypted password
        registerUser.setPassword(encodePassword);
        if(registerUser.getType().equals(ADVERTISER)){
            advertiserRepository.save(constructAdvertiserUser(registerUser));
        } else {
            jobSeekerRepository.save(constructJonSeekerUser(registerUser));
        }

        LoginUser loginUser = new LoginUser(registerUser.getEmail(), password, registerUser.getType());
        return loginUser(loginUser, model, request);
    }

    public String loginUser(LoginUser loginUser, Model model, HttpServletRequest request) {

        User user;
        String type = loginUser.getType();
        if(type.equals(ADVERTISER)){
            user = advertiserRepository.findByEmail(loginUser.getEmail());
        } else {
            user = jobSeekerRepository.findByEmail(loginUser.getEmail());
        }

        if(user == null || !BCryptUtils.matchPassword(loginUser.getPassword(), user.getPassword())) {
            invalidLogin(model);
            return AppConstants.JSPFile.HOME_PAGE;
        }

        SessionUtils.setSession(request, user.getId(), type);

        return type.equals(ADVERTISER)? REDIRECT_ADVERTISER: REDIRECT_JOB_SEEKERS;
    }

    public String logout(HttpServletRequest request) {
        SessionUtils.clearSession(request);
        return REDIRECT_HOME_PAGE;
    }

    private boolean validateUserRegistration(RegisterUser registerUser, Model model) {

        String userName = registerUser.getUserName();
        String email = registerUser.getEmail();
        String type = registerUser.getType();
        String password = registerUser.getPassword();
        String confirmPassword = registerUser.getConfirmPassword();


        if(userName == null || userName.isBlank() || userName.length() < 3 || !StringUtils.isAlphaSpace(userName)) {
            updateUserRegistrationError(model, LoginError.USERNAME_ERROR);
            return false;
        }

        if(email == null || email.isBlank()) {
            updateUserRegistrationError(model, LoginError.INVALID_EMAIL);
            return false;
        }

        if(advertiserRepository.findByEmail(email) != null) {
            updateUserRegistrationError(model, LoginError.EMAIL_EXIST);
            return false;
        }

        if(type == null || type.isBlank() || (!type.equals(JOB_SEEKER) && !type.equals(ADVERTISER))) {
            updateUserRegistrationError(model, LoginError.INVALID_TYPE);
            return false;
        }

        if(password == null || password.isBlank() || password.length() < 8) {
            updateUserRegistrationError(model, LoginError.PASSWORD_ERROR);
            return false;
        }

        if(!password.equals(confirmPassword)) {
            updateUserRegistrationError(model, LoginError.PASSWORD_MISS_MATCH);
            return false;
        }

        return true;
    }

    private void updateUserRegistrationError(Model model, String error) {
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(REGISTER_ERROR, error);
        objectMap.put(LOGIN_USER, new LoginUser());
    }

    private void invalidLogin(Model model) {
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(USER_LOGIN_ERROR, LoginError.INVALID_LOGIN);
        constructLoginDetails(model);
    }


    private Advertiser constructAdvertiserUser(RegisterUser registerUser) {
        return new Advertiser(registerUser.getUserName(), registerUser.getEmail(), registerUser.getPassword());
    }

    private JobSeeker constructJonSeekerUser(RegisterUser registerUser) {
        return new JobSeeker(registerUser.getUserName(), registerUser.getEmail(), registerUser.getPassword());
    }

    private void constructLoginDetails(Model model) {
        Map<String, Object> objectMap = model.asMap();
        objectMap.put(REGISTER_USER, new RegisterUser());
        objectMap.put(LOGIN_USER, new LoginUser());
    }
}

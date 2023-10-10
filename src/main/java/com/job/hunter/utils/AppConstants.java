package com.job.hunter.utils;

public class AppConstants {

    public static class JSPFile {
        public static final String HOME_PAGE = "index";

        public static final String ADVERTISER_HOME_PAGE = "advertiser-home-page";

        public static final String ADVERTISER_NEW_JOB = "advertiser-job-new";

        public static final String ADVERTISER_EDIT_JOB = "advertiser-job-edit";

        public static final String JOB_SEEKER_HOME_PAGE = "jobseeker-home-page";

        public static final String JOB_DETAILS_PAGE = "jobseeker-job-details-page";
    }

    public static class LoginError {
        public static final String INVALID_LOGIN = "Invalid Login";

        public static final String USERNAME_ERROR = "Error: Username - letter only, 3 characters, not blank";

        public static final String INVALID_EMAIL = "Error: Invalid Email format";

        public  static final String EMAIL_EXIST = "Error: Email already exist";

        public static final String PASSWORD_ERROR = "Error: Password - at least 8 characters, not blank";

        public static final String PASSWORD_MISS_MATCH = "Error: Password mismatch";

        public static final String INVALID_TYPE = "Error: Type should be [Job Seeker, Advertiser]";
    }

    public static final String REGISTER_USER = "registerUser";

    public static final String LOGIN_USER = "loginUser";

    public static final String USER_LOGIN_ERROR = "loginError";

    public static final String REDIRECT_HOME_PAGE = "redirect:/";

    public static final String REDIRECT_ADVERTISER = "redirect:/advertiser";

    public static final String REDIRECT_JOB_SEEKERS = "redirect:/jobSeekers";

    public static final String JOB_SEEKER = "Job Seeker";

    public static final String ADVERTISER = "Advertiser";

    public static final String REGISTER_ERROR = "registerError";

    public static final String USER_ID = "USER_ID";

    public static final String USER_TYPE = "type";

    public static final String USER = "user";

    public static final String JOB_LIST = "jobList";

    public static final String JOB = "job";

    public static final String APPLIED_JOB = "appliedJob";

    public static final String QUERY = "query";
}

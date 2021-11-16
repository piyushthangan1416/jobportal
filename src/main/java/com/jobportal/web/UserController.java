package com.jobportal.web;

import com.jobportal.dto.JobDetailsDto;
import com.jobportal.entities.UserProfile;
import com.jobportal.service.UserProfileService;
import com.jobportal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {

    Logger log = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "/viewuserprofile", method = RequestMethod.GET)
    public ModelAndView showJobPostForm(ModelAndView model, Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("viewuserprofile");
        UserProfile userProfile = userProfileService.findUserProfileByEmail(authentication.getName());
        log.info("userprofile: "+userProfile);
        modelAndView.addObject("profile",userProfile);
        return modelAndView;
    }
}

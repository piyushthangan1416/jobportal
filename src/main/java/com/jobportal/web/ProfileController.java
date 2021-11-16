package com.jobportal.web;

import com.jobportal.dto.UserProfileDto;
import com.jobportal.entities.UserProfile;
import com.jobportal.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ProfileController {
    Logger log = LoggerFactory.getLogger(ProfileController.class);
    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value ="/buildprofile",method= RequestMethod.GET)
    public ModelAndView userProfile(ModelAndView model,Authentication authentication) {
        UserProfile userProfile= userProfileService.findUserProfileByEmail(authentication.getName());
        ModelAndView modelandView = new ModelAndView("buildprofile");
        modelandView.addObject("userProfile",userProfile != null?userProfile:new UserProfileDto());
        return modelandView;


    }

    @RequestMapping(value="/buildprofile",method=RequestMethod.POST)
    public String buildprofile(@ModelAttribute("userProfile") @Valid  UserProfileDto userProfileDto, Authentication authentication
                                , BindingResult result)
    {
        log.info("userProfile : "+userProfileDto);
        log.info("result errors:"+result.getAllErrors());
        if(result.hasErrors()){
            return "buildprofile";

        }
        userProfileService.saveUserProfile(userProfileDto,authentication.getName());
       return  "redirect:/viewuserprofile";
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView jodDetails(ModelAndView model, @RequestParam("id") String id){
        ModelAndView modelAndView = new ModelAndView("viewuserprofile");
        modelAndView.addObject("profile", userProfileService.findById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/userstatus", method = RequestMethod.GET)
    public ModelAndView getUserJob(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("userstatus");
        modelAndView.addObject("jobstatus", userProfileService.findJobStatusByUser(authentication.getName()));
        return modelAndView;
    }
}

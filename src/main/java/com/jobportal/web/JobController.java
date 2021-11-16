package com.jobportal.web;

import com.jobportal.dto.JobDetailsDto;
import com.jobportal.service.JobService;
import com.jobportal.service.UserJobService;
import com.jobportal.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class JobController {
    Logger log = LoggerFactory.getLogger(JobController.class);
    @Autowired
    private JobService jobService;

    @Autowired
    private UserJobService userJobService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    @RequestMapping(value = "/postjob", method = RequestMethod.GET)
    public ModelAndView showJobPostForm(ModelAndView model){
        ModelAndView modelAndView = new ModelAndView("postjob");
        modelAndView.addObject("job", new JobDetailsDto());
        return modelAndView;
    }

    @RequestMapping(value = "/postjob", method = RequestMethod.POST)
    public String postJob( @ModelAttribute("job") @Valid JobDetailsDto jobDetailsDto, Authentication authentication
    , BindingResult result){
        log.info("job : "+jobDetailsDto);
        log.info("result.hasErrors():"+result.hasErrors());
        if(result.hasErrors()){
            return "postjob";

        }
        jobService.saveJob(jobDetailsDto,authentication.getName());

        return "redirect:/postjob?success";

    }

    @RequestMapping(value = "/job_listing", method = RequestMethod.GET)
    public ModelAndView jobListing(ModelAndView model){
        ModelAndView modelAndView = new ModelAndView("job_listing");
        modelAndView.addObject("jobs", jobService.findAllJobs());
        return modelAndView;
    }

    @RequestMapping(value = "/job_details/{id}", method = RequestMethod.GET)
    public ModelAndView jodDetails(ModelAndView model, @PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("job_details");
        modelAndView.addObject("job", jobService.findById(id));
        return modelAndView;
    }
    @RequestMapping(value = "/job/apply/{id}", method = RequestMethod.POST)
    public String jobApply(@PathVariable("id") String id,
                                 Authentication authentication){
        log.info("job id:"+id+" user email id:"+authentication.getName());
        userJobService.applyJob(id,authentication.getName());
        return  "redirect:/userstatus";
    }

    @RequestMapping(value = "/postedjoblist", method = RequestMethod.GET)
    public ModelAndView postedJobList(ModelAndView model , Authentication authentication,
                                      @RequestParam(name = "jobId",required = false) String jobId,
                                      @RequestParam(name = "action",required = false) String action){
        ModelAndView modelAndView = new ModelAndView("postedjoblist");
        if(jobId != null && action != null && "Delete".equalsIgnoreCase(action)){
            jobService.deleteJob(jobId);
        }
        modelAndView.addObject("jobs", jobService.findAllJobsByUserId(authentication.getName()));
        return modelAndView;
    }
    @RequestMapping(value = "/viewapplicants", method = RequestMethod.GET)
    public ModelAndView viewJobAppicants(ModelAndView model , Authentication authentication,
                                         @RequestParam(name = "jobId",required = false) String jobId,
                                         @RequestParam(name = "action",required = false) String action,
                                         @RequestParam(name = "userJobId",required = false) String userJobId){
        if(userJobId != null && action !=null && userJobId != null && !userJobId.isEmpty()){
            userJobService.updateUserJob(userJobId,action);
        }
        ModelAndView modelAndView = new ModelAndView("viewapplicants");
        modelAndView.addObject("profiles", jobService.findUSerByJobId(jobId));
        return modelAndView;
    }
}

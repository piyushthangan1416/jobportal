package com.jobportal.web;

import com.jobportal.dto.JobDetailsDto;
import com.jobportal.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/postjob")
public class JobController {
    Logger log = LoggerFactory.getLogger(JobController.class);
    @Autowired
    private JobService jobService;
    @GetMapping
    public ModelAndView showJobPostForm(ModelAndView model){
        ModelAndView modelAndView = new ModelAndView("postjob");
        modelAndView.addObject("job", new JobDetailsDto());
        return modelAndView;
    }
    @PostMapping
    public String postJob( @ModelAttribute("job") @Valid JobDetailsDto jobDetailsDto
    , BindingResult result){
        log.info("job : "+jobDetailsDto);
        log.info("result.hasErrors():"+result.hasErrors());
        if(result.hasErrors()){
            return "postjob";

        }
        jobService.saveJob(jobDetailsDto);

        return "redirect:/postjob?success";

    }

}

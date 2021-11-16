package com.jobportal.web;

import com.jobportal.dto.ReviewDto;
import com.jobportal.service.JobService;
import com.jobportal.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ReviewController {
    Logger log = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    private ReviewService reviewService;
    @RequestMapping(value ="/review" ,method= RequestMethod.GET)
    public ModelAndView postreview(ModelAndView model){
        ModelAndView modelAndView = new ModelAndView("enter_review");
        modelAndView.addObject("review",new ReviewDto());
        return modelAndView;
    }
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public String postReview(@ModelAttribute("review") @Valid ReviewDto reviewDto, Authentication authentication
                              , BindingResult result) {
        log.info("review :" + reviewDto);
        log.info("result.hasErrors():" + result.hasErrors());
        if (result.hasErrors()) {
            return "enter_review";
        }
        reviewDto.setUserId(authentication.getName());
        reviewService.saveReview(reviewDto);

        return "redirect:/enter_review?success";
    }

    @RequestMapping(value = "/reviewlist", method = RequestMethod.GET)
    public ModelAndView reviewListing(ModelAndView model){
        ModelAndView modelAndView = new ModelAndView("reviewlist");
        modelAndView.addObject("reviews", reviewService.findAllReview());
        return modelAndView;
    }

    @RequestMapping(value = "/reviewdetails/{id}", method = RequestMethod.GET)
    public ModelAndView reviewDetails(ModelAndView model, @PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("reviewdetails");
        modelAndView.addObject("review", reviewService.findById(id));
        return modelAndView;
    }
}

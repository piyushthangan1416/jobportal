package com.jobportal.web;

import java.util.List;

import javax.validation.Valid;

import com.jobportal.dto.UserRegistrationDto;
import com.jobportal.entities.Role;
import com.jobportal.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportal.repositories.RoleRepository;
import com.jobportal.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    Logger log = LoggerFactory.getLogger(UserRegistrationController.class);
    
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @ModelAttribute("rolesList")
    public List<Role> listOfRoles(){
        return roleRepository.findAll();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }
    
    @PostMapping
    public String registerUserAccount(
        @ModelAttribute("user")
        @Valid UserRegistrationDto userDto,
        BindingResult result){
        log.info("user : "+userDto);
            User existing = userService.findByEmail(userDto.getEmail());
            if(existing!=null){
                result.rejectValue("email", null,
                "There is already an account registred with that email");
            }
        log.info("result.hasErrors():"+result.hasErrors());
            if(result.hasErrors()){
                return "registration";
            }

            userService.saveUser(userDto);

            return "redirect:/registration?success";
        }
}
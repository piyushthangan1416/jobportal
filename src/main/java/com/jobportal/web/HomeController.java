package com.jobportal.web;

import java.security.Principal;

import com.jobportal.entities.Message;
import com.jobportal.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobportal.service.MessageService;
import com.jobportal.service.UserService;

/**
 * @author Caio Fernando
 */

 @Controller
public class HomeController {    
    
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    private User user;


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/home")
    public String home(Principal principal,Model model){        
        user=userService
        .findByEmail(
            principal.getName()
        );
        model.addAttribute("msgs"
                            ,messageService
                            .messageList(
                                user
                                ));
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage(Principal principal
                            , Message message){
        messageService.saveMessage(
                                user
                                , message);
        return "redirect:/home";
    }
}
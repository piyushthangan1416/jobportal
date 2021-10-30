package com.jobportal.service;

import com.jobportal.dto.UserRegistrationDto;
import com.jobportal.entities.User;
import com.jobportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(UserRegistrationDto userRegistrationDto){
        User user = new User();
        
        StringBuilder name = new StringBuilder(
                            userRegistrationDto.getFirstName());
        name.append(" "+userRegistrationDto.getLastName());
        user.setName(name.toString());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(
                            userRegistrationDto
                            .getPassword()));
        user.setRoles(Arrays.asList(userRegistrationDto.getRole()));

        userRepository.save(user);
    }

    public User findByEmail(String email){
        User user=null;
        try {
            user =userRepository.
                    findByEmail(email).get();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
                            
    }


                         
}
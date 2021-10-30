package com.jobportal.service;

import java.util.List;

import com.jobportal.entities.Message;
import com.jobportal.entities.User;
import com.jobportal.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> messageList(User user) {

        return messageRepository.
                findByUser(
                    user
                );
    }

    public void saveMessage(User user,
                            Message message){
        message.setUser(
            user
        );
        messageRepository.save(message);
        
    }
}
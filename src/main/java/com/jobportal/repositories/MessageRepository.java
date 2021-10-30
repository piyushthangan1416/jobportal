package com.jobportal.repositories;

import java.util.List;

import com.jobportal.entities.Message;
import com.jobportal.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Caio Fernando
 */
@Repository
public interface MessageRepository extends MongoRepository<Message,Integer>
{
    
    List<Message> findByUser(User user);
}
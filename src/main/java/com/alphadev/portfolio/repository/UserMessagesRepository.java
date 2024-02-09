package com.alphadev.portfolio.repository;

import com.alphadev.portfolio.entity.UserMessages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessagesRepository extends MongoRepository<UserMessages, String> {
}

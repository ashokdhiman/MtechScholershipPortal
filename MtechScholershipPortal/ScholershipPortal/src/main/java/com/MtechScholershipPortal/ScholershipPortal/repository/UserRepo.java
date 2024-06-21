package com.MtechScholershipPortal.ScholershipPortal.repository;

import com.MtechScholershipPortal.ScholershipPortal.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findByUserName(String username);
}

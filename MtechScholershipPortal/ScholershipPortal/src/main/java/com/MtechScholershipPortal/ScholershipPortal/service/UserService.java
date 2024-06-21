package com.MtechScholershipPortal.ScholershipPortal.service;

import com.MtechScholershipPortal.ScholershipPortal.entity.User;
import com.MtechScholershipPortal.ScholershipPortal.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(String id){
        return userRepo.findById(id);
    }

    public void deleteById(String id){
        userRepo.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
}

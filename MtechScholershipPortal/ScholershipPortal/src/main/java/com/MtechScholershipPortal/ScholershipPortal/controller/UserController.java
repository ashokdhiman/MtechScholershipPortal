package com.MtechScholershipPortal.ScholershipPortal.controller;

import com.MtechScholershipPortal.ScholershipPortal.entity.User;
import com.MtechScholershipPortal.ScholershipPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class  UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public boolean createUser(@RequestBody User user){
        userService.saveUser(user);
        return true;
    }

    @PutMapping("{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String username){
        User userInDb=userService.findByUserName(username);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userInDb.setUserType(user.getUserType());
            userService.saveUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

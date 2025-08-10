package com.example.journalentry.controller;

import com.example.journalentry.entity.User;
import com.example.journalentry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-entry")
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PostMapping("/add-entry")
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping("/update-entry/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
        User userinDb = userService.findByUserName(userName);
        if(userinDb != null){
            userinDb.setUserName(user.getUserName() != null && !user.getUserName().isEmpty() ? user.getUserName() : userinDb.getUserName());
            userinDb.setPassWord(user.getPassWord() != null && !user.getPassWord().isEmpty() ? user.getPassWord() : userinDb.getPassWord());
            userService.saveEntry(userinDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

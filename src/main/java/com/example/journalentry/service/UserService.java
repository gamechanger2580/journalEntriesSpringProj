package com.example.journalentry.service;

import com.example.journalentry.entity.User;
import com.example.journalentry.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(User user){
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

    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }
}

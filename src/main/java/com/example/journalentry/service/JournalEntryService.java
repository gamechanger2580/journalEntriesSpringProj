package com.example.journalentry.service;

import com.example.journalentry.JournalentryApplication;
import com.example.journalentry.entity.JournalEntry;
import com.example.journalentry.entity.User;
import com.example.journalentry.repository.JournalEntryRepo;
import com.example.journalentry.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    // directly obj created
    // as journalEntryRepo's is instance is made as it was interface
    // cant be called directly
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userService;

    

    public void saveEntry(JournalEntry journalEntry, String userName){
        User user = userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        journalEntry.setUser(user);
        JournalEntry saved = journalEntryRepo.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }


    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(String id){
        return journalEntryRepo.findById(id);
    }

    public void deleteById(String id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepo.deleteById(id);
    }

    public List<JournalEntry> getEntriesForUser(String userId){
        return journalEntryRepo.findByUserId(userId);
    }


}

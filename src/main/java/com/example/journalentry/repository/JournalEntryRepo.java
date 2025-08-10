package com.example.journalentry.repository;

import com.example.journalentry.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// our JpaRepository<JournalEntry, String>
// Class on which I have to do ops on, the id (the id is of String type)
@Repository
public interface JournalEntryRepo extends JpaRepository<JournalEntry, String> {

    // custome abstract method made in repo layer
    List<JournalEntry> findByUserId(String userId);
}

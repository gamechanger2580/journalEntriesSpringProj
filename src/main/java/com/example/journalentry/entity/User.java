package com.example.journalentry.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    @NonNull
    // this annotation will do null check before setting
    // before using setter
    private String userName;
    @NonNull
    private String passWord;

    // now I want to link journalEntry with respect to the users
    // that is the user will have access to the journalEntry which he have created
    // so now journalEntries will contain list of journalEntries

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<JournalEntry> journalEntries = new ArrayList<>();
    // if that user remove the journalEntry then all the instances will be removed (orphanRemoval = true)
    // cascade = CascadeType.ALL is it will save journalEntry in user (that is the id of user like which user has this)
    // and vice versa , so we dont need to call it manually to save it in both
    // JournalEntry. CascadeType.ALL lets persist/remove propagate.


}

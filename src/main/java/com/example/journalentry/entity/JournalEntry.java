package com.example.journalentry.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "users_id") //fk in jounralEntry table
    @JsonBackReference
    private User user;
}

package com.darkcoder.backend.repository;

import com.darkcoder.backend.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);
}

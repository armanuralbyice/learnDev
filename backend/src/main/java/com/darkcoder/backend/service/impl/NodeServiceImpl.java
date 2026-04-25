package com.darkcoder.backend.service.impl;

import com.darkcoder.backend.dto.NoteDto;
import com.darkcoder.backend.dto.Response;
import com.darkcoder.backend.entity.Note;
import com.darkcoder.backend.repository.NoteRepository;
import com.darkcoder.backend.service.NoteService;
import com.darkcoder.backend.service.UtilityService;
import com.darkcoder.backend.utils.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class NodeServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final UtilityService utilityService;
    
    @Override
    public Response createNote(NoteDto noteDto) {
        Note note;
        note = noteRepository.findByTitle(noteDto.getTitle());
        if (note != null){
            ResponseBuilder.getFailResponse(HttpStatus.CONFLICT, "Already Exists");
        }
        note = utilityService.map(noteDto, Note.class);
        noteRepository.save(note);
        return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, null, "Note created successfully");
    }
}

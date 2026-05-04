package com.darkcoder.backend.controller;

import com.darkcoder.backend.dto.NoteDto;
import com.darkcoder.backend.dto.Response;
import com.darkcoder.backend.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/note")
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/create")
    public Response createNote (@RequestBody NoteDto noteDto){
        return noteService.createNote(noteDto);
    }
}

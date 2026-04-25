package com.darkcoder.backend.service;

import com.darkcoder.backend.dto.NoteDto;
import com.darkcoder.backend.dto.Response;

public interface NoteService {
    Response createNote (NoteDto noteDto);
}

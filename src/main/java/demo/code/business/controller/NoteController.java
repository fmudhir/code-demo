package demo.code.business.controller;

import demo.code.api.graphql.gro.Note;
import demo.code.business.mapper.NoteMapper;
import demo.code.data.service.NoteService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NoteController {
    private NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    public List<Note> getNotes() {
        return NoteMapper.toNoteGros(noteService.getNotes());
    }
}

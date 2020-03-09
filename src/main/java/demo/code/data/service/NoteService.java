package demo.code.data.service;

import demo.code.business.dto.NoteDto;
import demo.code.data.mapper.NoteMapper;
import demo.code.data.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
//    @Autowired
//    private NoteRepository noteRepository;

    public List<NoteDto> getNotes() {
        return NoteMapper.toNoteDtos(noteRepository.findAll());
    }
}

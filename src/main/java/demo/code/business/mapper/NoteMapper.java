package demo.code.business.mapper;

import demo.code.api.graphql.gro.Note;
import demo.code.business.dto.NoteDto;

import java.util.List;
import java.util.stream.Collectors;

public class NoteMapper {
    public static Note toNoteGro(NoteDto dto) {
        return new Note().setId(dto.getId()).setText(dto.getText());
    }

    public static List<Note> toNoteGros(List<NoteDto> dtos) {
        return dtos.stream().collect(
                Collectors.mapping(o -> toNoteGro(o), Collectors.toList())
        );
    }
}

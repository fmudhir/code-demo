package demo.code.data.mapper;

import demo.code.business.dto.NoteDto;
import demo.code.data.model.NoteModel;

import java.util.List;
import java.util.stream.Collectors;

public class NoteMapper {
    public static NoteDto toNoteDto(NoteModel model) {
        return new NoteDto().setId(model.getId()).setText(model.getText());
    }

    public static List<NoteDto> toNoteDtos(List<NoteModel> models) {
        return models.stream().collect(
                Collectors.mapping(o -> toNoteDto(o), Collectors.toList())
        );
    }
}

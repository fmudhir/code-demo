package demo.code.data.mapper;

import demo.code.business.dto.TextDto;
import demo.code.data.model.TextModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TextMapper {
    public static TextDto toTextDto(TextModel model) {
        return new TextDto().setId(model.getId()).setEntityId(model.getEntityId()).setText(model.getText());
    }

    public static Optional<TextDto> toTextDto(Optional<TextModel> model) {
        if (!model.isPresent())
            return Optional.empty();
        return Optional.of(toTextDto(model.get()));
    }

    public static List<TextDto> toTextDtos(List<TextModel> models) {
        return models.stream().collect(
                Collectors.mapping(o -> toTextDto(o), Collectors.toList())
        );
    }

    public static TextModel toTextModel(TextDto textDto) {
        return new TextModel().setEntityId(textDto.getEntityId()).setText(textDto.getText());
    }

}

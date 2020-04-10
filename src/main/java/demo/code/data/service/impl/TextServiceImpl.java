package demo.code.data.service.impl;

import demo.code.business.dto.TextDto;
import demo.code.data.mapper.TextMapper;
import demo.code.data.model.TextModel;
import demo.code.data.repository.TextRepository;
import demo.code.data.service.TextService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextServiceImpl implements TextService {

    private final TextRepository textRepository;

    public TextServiceImpl(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public List<TextDto> getTextsByEntityId(Long entityId) {
        return TextMapper.toTextDtos(textRepository.findByEntityId(entityId));
    }

    public Optional<TextDto> getTextById(Long id) {
        Optional<TextModel> textModel = textRepository.findById(id);
        return TextMapper.toTextDto(textModel);
    }

    public void saveText(TextDto textDto) {
        textRepository.save(TextMapper.toTextModel(textDto));
    }
}

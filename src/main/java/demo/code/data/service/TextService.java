package demo.code.data.service;

import demo.code.business.dto.TextDto;
import demo.code.data.mapper.TextMapper;
import demo.code.data.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService {

    private final TextRepository textRepository;

    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public List<TextDto> getTextsByEntityId(Long entityId) {
        return TextMapper.toTextDtos(textRepository.findByEntityId(entityId));
    }

    public void saveText(TextDto textDto) {
        textRepository.save(TextMapper.toTextModel(textDto));
    }
}

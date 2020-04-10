package demo.code.data.service;

import demo.code.business.dto.TextDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TextService {
    List<TextDto> getTextsByEntityId(Long entityId);
    Optional<TextDto> getTextById(Long id);
    void saveText(TextDto textDto);
}

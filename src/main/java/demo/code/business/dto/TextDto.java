package demo.code.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TextDto {
    private Long id;
    private Long entityId;
    private String text;
}

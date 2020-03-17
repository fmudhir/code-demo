package demo.code.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BulletDto {
    private Long id;
    private Long groupId;
    private String bullet;
}

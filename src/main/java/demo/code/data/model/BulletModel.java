package demo.code.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "bullet")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BulletModel {
    @Embedded
    private Essential essential;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long groupId;

    @Enumerated(EnumType.STRING)
    private BulletType type;

    private String bullet;
}

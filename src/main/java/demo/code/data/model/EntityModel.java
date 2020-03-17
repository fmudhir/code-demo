package demo.code.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "entity")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class EntityModel {

    @Embedded
    private Essential essential;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EntityType type;

    private String name;
}

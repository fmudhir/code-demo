package demo.code.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "text")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TextModel {

    @Embedded
    private Essential essential;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long entityId;

    private String text;
}

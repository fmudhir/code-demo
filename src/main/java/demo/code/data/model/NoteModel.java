package demo.code.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class NoteModel {

    @Embedded
    private Essential essential;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
}

package demo.code.data.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Essential class represent an embeddable
 * object that carries the fields that should
 * exist on most/all model classes (entities)
 *
 * @author  Faisal Mudhir
 * @version 1.0
 * @since   2020-03-09
 */
@Embeddable
public class Essential {
    @Temporal(TemporalType.TIMESTAMP)
    private Date modification;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
}

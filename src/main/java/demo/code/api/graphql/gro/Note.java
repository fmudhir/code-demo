package demo.code.api.graphql.gro;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Note {
    @GraphQLQuery(name = "id")
    private Long id;
    @GraphQLQuery(name =  "text")
    private String text;
}

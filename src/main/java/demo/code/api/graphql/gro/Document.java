package demo.code.api.graphql.gro;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Document {
    @GraphQLQuery(name = "id")
    private Long id;
    @GraphQLQuery(name =  "content")
    private String content;
}

package demo.code.api.graphql.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphQLRequest {
    private String query;
    private String variables;
    private String operationName;
}

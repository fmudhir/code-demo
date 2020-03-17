package demo.code.api.graphql.graph;

import demo.code.api.graphql.gro.Document;
import demo.code.business.controller.DocumentController;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentQuery {

    private DocumentController documentController;

    public DocumentQuery(DocumentController documentController) {
        this.documentController = documentController;
    }

    @GraphQLQuery(name = "document")
    public List<Document> getDocuments(@GraphQLArgument(name = "topic") String topic) {
        return documentController.getDocuments(topic);
    }
}

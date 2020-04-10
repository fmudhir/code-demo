package demo.code.unit.mockito.api.graphql;

import demo.code.api.graphql.graph.DocumentQuery;
import demo.code.api.graphql.gro.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class DocumentGraphUnitTest {
    @MockBean
    private DocumentQuery documentQuery;

    @Autowired
    ApplicationContext context;

    private static final String CONTENT = "Mocked Content";
    private static final String TOPIC = "Mocked Topic";
    private static final Long ID = 123L;

    @Before
    public void setUp() {
        Document document = new Document().setId(ID)
                .setContent(CONTENT);

        Mockito.when(documentQuery.getDocuments(TOPIC))
                .thenReturn(Arrays.asList(document));
    }

    @Test
    public void testGraphDocumentValidateContentByTopic() {
        DocumentQuery documentQueryFromContext = context.getBean(DocumentQuery.class);
        List<Document> found = documentQueryFromContext.getDocuments(TOPIC);

        Assert.assertEquals(false, found.isEmpty());
        Assert.assertEquals(CONTENT, found.get(0).getContent());
    }
}

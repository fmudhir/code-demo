package demo.code.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.code.CodeDemoApplication;
import demo.code.api.graphql.configuration.GraphQLRequest;
import demo.code.business.dto.CompanyDto;
import demo.code.data.service.EntityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = CodeDemoApplication.class, loader = AnnotationConfigContextLoader.class)
public class ClassicUnitTest {
    @Autowired
    private EntityService entityService;

    @Test
    public void testEntityCompany() {
        entityService.saveEntity(new CompanyDto().setName("BHHC"));
        Optional<CompanyDto> company = entityService.getCompanyByName("BHHC");
        assertThat(company.isPresent());
    }

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void textApiDocument() throws JsonProcessingException {
        // graphql all requests are posts, follows the structure of query: "", variables:"", operationName: ""
        // a GET call with graphql equivalent to issuing a REST call with POST body like follows:
        String json = "{\"query\":\" {document(topic: \\\"BHHC\\\") {id content}}\",\"variables\":null,\"operationName\":null}";

        ObjectMapper om = new ObjectMapper();
        GraphQLRequest postBody = om.readValue(json, GraphQLRequest.class);

        // call the api
        String response = this.restTemplate.postForObject("/graphql", postBody, String.class);

        // ensuring the response to our query matches our expectation:
        Assert.assertEquals("{\"data\":{\"document\":[{\"id\":48596,\"content\":\"These are the reasons I'd like"
                + " to work for BHHC: \\nWarren Buffet\\nOld, stable and respected company\\n Scale of a national "
                + "company but headquartered in Omaha\\n\"}]}}", response);
    }
}

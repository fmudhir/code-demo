package demo.code;

import demo.code.business.dto.CompanyDto;
import demo.code.data.service.EntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CodeDemoApplication.class, loader = AnnotationConfigContextLoader.class)
public class CodeDemoApplicationTest {
    @Autowired
    private EntityService entityService;

    @Test
    public void testEntity() {
        entityService.saveEntity(new CompanyDto().setName("BHHC"));
        Optional<CompanyDto> company = entityService.getCompanyByName("BHHC");
        assertThat(company.isPresent());
    }
}

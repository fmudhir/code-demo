package demo.code.unit.mockito.data.repository;

import demo.code.data.model.EntityModel;
import demo.code.data.model.EntityType;
import demo.code.data.repository.EntityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class EntityRepositoryUnitTest {
    @MockBean
    private EntityRepository entityRepository;

    @Autowired
    ApplicationContext context;

    private static final String NAME = "Mocked Name";
    private static final Long ID = 123L;
    private static final EntityType TYPE = EntityType.COMPANY;

    @Before
    public void setUp() {
        EntityModel entityModel = new EntityModel().setId(ID)
                .setType(TYPE)
                .setName(NAME);

        Mockito.when(entityRepository.findById(entityModel.getId()))
                .thenReturn(Optional.of(entityModel));
        Mockito.when(entityRepository.findByTypeAndName(EntityType.COMPANY, entityModel.getName()))
                .thenReturn(Optional.of(entityModel));
    }

    @Test
    public void testRepositoryEntityValidateCompanyId() {
        EntityRepository entityRepoFromContext = context.getBean(EntityRepository.class);
        Optional<EntityModel> found = entityRepoFromContext.findById(ID);

        Assert.assertEquals(true, found.isPresent());
        Assert.assertEquals(ID, found.get().getId());
    }

    @Test
    public void testRepositoryEntityValidateCompanyName() {
        EntityRepository entityRepoFromContext = context.getBean(EntityRepository.class);
        Optional<EntityModel> found = entityRepoFromContext.findByTypeAndName(TYPE, NAME);

        Assert.assertEquals(true, found.isPresent());
        Assert.assertEquals(NAME, found.get().getName());
    }
}

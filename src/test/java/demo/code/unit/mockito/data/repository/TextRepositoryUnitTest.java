package demo.code.unit.mockito.data.repository;

import demo.code.data.model.TextModel;
import demo.code.data.repository.TextRepository;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
public class TextRepositoryUnitTest {

    @MockBean
    private TextRepository textRepository;

    @Autowired
    ApplicationContext context;

    private static final String TEXT = "Mocked Text";
    private static final Long ID = 123L;
    private static final Long ENTITY_ID = 1234L;

    @Before
    public void setUp() {
        TextModel textModel = new TextModel().setId(ID)
                .setText(TEXT)
                .setEntityId(ENTITY_ID);

        Mockito.when(textRepository.findByEntityId(textModel.getEntityId()))
                .thenReturn(Arrays.asList(textModel));
        Mockito.when(textRepository.findById(textModel.getId()))
                .thenReturn(Optional.of(textModel));
    }

    @Test
    public void testServiceTextValidateId() {
        TextRepository textRepoFromContext = context.getBean(TextRepository.class);
        Optional<TextModel> found = textRepoFromContext.findById(ID);

        Assert.assertEquals(true, found.isPresent());
        Assert.assertEquals(ID, found.get().getId());
        Mockito.verify(textRepository).findById(ID);
    }

    @Test
    public void testServiceTextValidateEntityId() {
        TextRepository textRepoFromContext = context.getBean(TextRepository.class);
        List<TextModel> found = textRepoFromContext.findByEntityId(ENTITY_ID);

        Assert.assertEquals(false, found.isEmpty());
        Assert.assertEquals(ENTITY_ID, found.get(0).getEntityId());
        Mockito.verify(textRepository).findByEntityId(ENTITY_ID);
    }
}

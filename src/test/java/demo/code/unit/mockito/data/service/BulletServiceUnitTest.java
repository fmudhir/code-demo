package demo.code.unit.mockito.data.service;

import demo.code.business.dto.BulletDto;
import demo.code.data.service.BulletService;
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
public class BulletServiceUnitTest {

    @MockBean
    private BulletService bulletService;

    @Autowired
    ApplicationContext context;

    private static final String BULLET = "Mocked Bullet";
    private static final Long ID = 123L;
    private static final Long GROUP_ID = 1234L;

    @Before
    public void setUp() {
        BulletDto bulletDto = new BulletDto().setId(ID)
                .setBullet(BULLET)
                .setGroupId(GROUP_ID);

        Mockito.when(bulletService.getTextBulletsByGroupIds(Arrays.asList(GROUP_ID))) .thenReturn(Arrays.asList(bulletDto));
    }

    @Test
    public void testServiceBulletValidateGroupId() {
        BulletService bulletServiceFromContext = context.getBean(BulletService.class);
        List<BulletDto> found = bulletServiceFromContext.getTextBulletsByGroupIds(Arrays.asList(GROUP_ID));

        Assert.assertEquals(false, found.isEmpty());
        Assert.assertEquals(GROUP_ID, found.get(0).getGroupId());
        Mockito.verify(bulletService).getTextBulletsByGroupIds(Arrays.asList(GROUP_ID));
    }
}

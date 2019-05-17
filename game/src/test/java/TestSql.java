import com.foolox.game.Application;
import com.foolox.game.common.repo.domain.SystemDict;
import com.foolox.game.common.repo.mapper.SystemDictMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 16/05/2019
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestSql {
    @Autowired
    private SystemDictMapper mapper;

    @Test
    public void testSql() {
        SystemDict dict = mapper.findOneByCode("foolox");
        System.out.println(dict);
        List<SystemDict> byParentId = mapper.findByParentId(1l);
        System.out.println(byParentId);
    }
}

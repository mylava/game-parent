import com.foolox.game.Application;
import com.foolox.game.common.repo.domain.MybatisTest;
import com.foolox.game.common.repo.mapper.MybatisTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * comment: 测试springboot 集成 mybatis
 *
 * @author: lipengfei
 * @date: 07/05/2019
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestSpringbootMybatis {
    @Autowired
    MybatisTestMapper mybatisTestMapper;

    @Test
    public void testMybatis() {
        MybatisTest mybatisTest = mybatisTestMapper.selectByPrimaryKey(1l);
        log.info("---------{}",mybatisTest);
    }
}

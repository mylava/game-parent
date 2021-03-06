import com.foolox.game.Application;
import com.foolox.game.common.repo.domain.MybatisTest;
import com.foolox.game.common.repo.mapper.MybatisTestMapper;
import com.foolox.game.common.util.redis.RedisService;
import com.foolox.game.common.util.redis.UserKey;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 16/05/2019
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestSpringbootRedis {
    @Autowired
    RedisService redisService;

    @Test
    public void testMybatis() {
        redisService.set(UserKey.PREFIX_TOKEN,"张三","12345678");
        log.info("---------{}",redisService.get(UserKey.PREFIX_TOKEN,"张三",String.class));
    }
}

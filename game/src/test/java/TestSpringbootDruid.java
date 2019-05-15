import com.foolox.game.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * comment: 测试springboot 集成 druid
 *
 * @author: lipengfei
 * @date: 07/05/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestSpringbootDruid {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from test where id='1'");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String cityName = resultSet.getString("name");
            System.out.println(cityName);
        }
    }

}

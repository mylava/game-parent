package com.foolox.game.core.server;

import com.foolox.game.common.repo.domain.SystemDict;
import com.foolox.game.common.repo.domain.example.SystemDictExample;
import com.foolox.game.common.repo.mapper.SystemDictMapper;
import com.foolox.game.core.FooloxDataContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * comment: 服务启动时，启动 socket server
 *
 * @author: lipengfei
 * @date: 06/05/2019
 */
@Component
public class ServerRunner implements CommandLineRunner {

    @Autowired
    private SystemDictMapper systemDictMapper;
    private final GameServer server;

    @Autowired
    public ServerRunner(GameServer server) {
        this.server = server;
    }


    public void initGame() {

    }

    @Override
    public void run(String... args) throws Exception {
        initGame();
        server.start();
        FooloxDataContext.setServerRunning(true);
    }


    private void cacheGames() {
//        SystemDictExample example = new SystemDictExample();
//        example.createCriteria().andNameEqualTo(FooloxDataContext.SYSTEM_ORGI);
//        List<SystemDict> systemDicts = systemDictMapper.selectByExample(example);

        //租户信息
        SystemDict orgiInfo = systemDictMapper.findOneByCode(FooloxDataContext.SYSTEM_ORGI);
        if (null==orgiInfo || null==orgiInfo.getId()) {
            return;
        }

        List<SystemDict> byParentId = systemDictMapper.findByParentId(orgiInfo.getParentId());



    }


}

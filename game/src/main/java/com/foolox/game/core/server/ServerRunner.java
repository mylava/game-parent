package com.foolox.game.core.server;

import com.foolox.game.core.FooloxDataContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * comment: 服务启动时，启动 socket server
 *
 * @author: lipengfei
 * @date: 06/05/2019
 */
@Component
public class ServerRunner implements CommandLineRunner {
    private final GameServer server;

    @Autowired
    public ServerRunner(GameServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        FooloxDataContext.setServerRunning(true);
    }
}

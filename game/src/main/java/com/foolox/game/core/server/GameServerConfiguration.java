package com.foolox.game.core.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 06/05/2019
 */
@org.springframework.context.annotation.Configuration
public class GameServerConfiguration {
    @Value("${foolox.server.port}")
    private Integer port;
    private GameEventHandler handler = new GameEventHandler();

    @Bean
    public GameServer socketIOServer() throws NoSuchAlgorithmException, IOException {
        GameServer server = new GameServer(port , handler) ;
        handler.setServer(server);
        return server;
    }
}

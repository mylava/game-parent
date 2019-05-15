package com.foolox.game.web.api.result;

import com.foolox.game.core.engin.game.FooloxGame;
import com.foolox.game.web.api.cache.model.ClientSession;
import lombok.Data;

import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 11/05/2019
 */
@Data
public class LoginResult {
    //    private Token token ;
    private String token;
    private List<FooloxGame> games;
    private ClientSession clientSession;
}

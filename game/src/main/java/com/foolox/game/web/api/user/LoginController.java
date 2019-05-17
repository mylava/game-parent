package com.foolox.game.web.api.user;

import com.foolox.game.common.repo.domain.Player;
import com.foolox.game.common.result.CodeMessage;
import com.foolox.game.common.result.Result;
import com.foolox.game.common.service.LoginService;
import com.foolox.game.common.util.FooloxUtils;
import com.foolox.game.common.util.JwtUtils;
import com.foolox.game.common.util.cache.hazelcast.HazelcastContext;
import com.foolox.game.core.FooloxDataContext;
import com.foolox.game.core.engin.game.FooloxGame;
import com.foolox.game.web.api.cache.model.ClientSession;
import com.foolox.game.web.api.result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 11/05/2019
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping
    public Result<LoginResult> guest(@RequestBody Player player) {
        ClientSession clientSession = null;

        Player p = loginService.findPlayerByUsername(player.getUsername());
        //不存在的用户
        if(p==null){
            return Result.error(CodeMessage.LOGIN_USER_NOT_EXIST);
        }

        //密码错误
        if (!p.getPassword().equals(player.getPassword())){
            return Result.error(CodeMessage.LOGIN_PASSWORD_INCORRECT);
        }

        String token = JwtUtils.createJWT(player);

        LoginResult data = new LoginResult();
        data.setToken(token);

        //token放入缓存
//        HazelcastContext.getApiUserCacheBean().put(player.getId(),token);

        //生成clientSession
        clientSession = new ClientSession();
        clientSession.setId(player.getId());
        clientSession.setToken(token);
        clientSession.setUsername(player.getUsername());
        clientSession.setPassword(FooloxUtils.md5(player.getPassword()));
        clientSession.setLogin(true);
        clientSession.setOnline(false);
        clientSession.setHeadimg(player.getHeadimg());

        clientSession.setOrgi(FooloxDataContext.SYSTEM_ORGI);

        HazelcastContext.getApiUserCacheBean().put(player.getId(),clientSession);

        data.setClientSession(clientSession);

        //STAY 实现route功能
        //STAY 读取系统配置信息，如 游戏模式(大厅、房卡)、房间等待时长、活动信息等

        //STAY 读取游戏配置：模式和玩法等，如果有多个，进入大厅，如果只有一个，进入选场（如低中高级场）
        data.setGames(getGames(clientSession.getOrgi()));
        





//        return new ResponseEntity<>(playerResultData, HttpStatus.OK);
        return null;
    }

    private List<FooloxGame> getGames(String orgi) {
        return null;

    }


}

package com.foolox.game.web.api.user;

import com.foolox.game.common.repo.domain.Player;
import com.foolox.game.common.result.CodeMessage;
import com.foolox.game.common.result.Result;
import com.foolox.game.common.service.LoginService;
import com.foolox.game.common.util.FooloxUtils;
import com.foolox.game.common.util.JwtUtils;
import com.foolox.game.common.util.cache.hazelcast.HazelcastContext;
import com.foolox.game.web.api.cache.model.ClientSession;
import com.foolox.game.web.api.result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        HazelcastContext.getApiUserCacheBean().put(player.getId(),clientSession);

        data.setClientSession(clientSession);

        //STAY 实现route功能
        //STAY 读取系统配置信息，如 游戏模式(大厅、房卡)、房间等待时长、活动信息等

        //STAY 读取游戏配置：模式和玩法等，如果有多个，进入大厅，如果只有一个，进入选场（如低中高级场）






//        String ip = UKTools.getIpAddr(request);
//        IP ipdata = IPTools.getInstance().findGeography(ip);
//        if (clientSession == null) {
//            try {
//                clientSession = register(new PlayUser(), ipdata, request);
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        if (userToken == null) {
//            userToken = new Token();
//            userToken.setIp(ip);
//            userToken.setRegion(ipdata.getProvince() + ipdata.getCity());
//            userToken.setId(UKTools.getUUID());
//            userToken.setUserid(clientSession.getId());
//            userToken.setCreatetime(new Date());
//            userToken.setOrgi(clientSession.getOrgi());
//            AccountConfig config = CacheConfigTools.getGameAccountConfig(BMDataContext.SYSTEM_ORGI);
//            if (config != null && config.getExpdays() > 0) {
//                userToken.setExptime(new Date(System.currentTimeMillis() + 60 * 60 * 24 * config.getExpdays() * 1000));//默认有效期 ， 7天
//            } else {
//                userToken.setExptime(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 7 * 1000));//默认有效期 ， 7天
//            }
//            userToken.setLastlogintime(new Date());
//            userToken.setUpdatetime(new Date(0));
//
//            tokenESRes.save(userToken);
//        }
//        clientSession.setToken(userToken.getId());
//        CacheHelper.getApiUserCacheBean().put(userToken.getId(), userToken, userToken.getOrgi());
//        CacheHelper.getApiUserCacheBean().put(clientSession.getId(), clientSession, userToken.getOrgi());
//        ResultData playerResultData = new ResultData(clientSession != null, clientSession != null ? MessageEnum.USER_REGISTER_SUCCESS : MessageEnum.USER_REGISTER_FAILD_USERNAME, clientSession, userToken);
//        GameConfig gameConfig = CacheConfigTools.getGameConfig(userToken.getOrgi());
//        if (gameConfig != null) {
//            playerResultData.setGametype(gameConfig.getGamemodel());
//            playerResultData.setNoaiwaitime(gameConfig.getTimeout());    //无AI的时候 等待时长
//            playerResultData.setNoaimsg(gameConfig.getTimeoutmsg());    //无AI的时候，到达最大时长以后的 提示消息，提示完毕后，解散房间
//
//            playerResultData.setSubsidy(gameConfig.isSubsidy());        //是否启用了破产补助
//            playerResultData.setSubtimes(gameConfig.getSubtimes());        //每天破产补助的次数
//            playerResultData.setSubgolds(gameConfig.getSubgolds());        //每次破产补助的金额
//
//            playerResultData.setSubmsg(gameConfig.getSubmsg());
//
//            playerResultData.setRecmsg(gameConfig.getRecmsg());
//
//            playerResultData.setLefttimes(gameConfig.getSubtimes());    //需要从数据库中查询当天剩余次数
//
//            /**
//             * 启用的游戏类型
//             */
//            playerResultData.setWelfare(gameConfig.getWelfare());
//
//            /**
//             * 封装 游戏对象，发送到客户端
//             */
//            /**
//             * 找到游戏配置的 模式 和玩法，如果多选，则默认进入的是 大厅模式，如果是单选，则进入的是选场模式
//             */
//            playerResultData.setGames(GameUtils.games(gameConfig.getGametype()));
//        }
//        AiConfig aiConfig = CacheConfigTools.getAiConfig(userToken.getOrgi());
//        if (aiConfig != null) {
//            playerResultData.setEnableai(aiConfig.isEnableai());
//            playerResultData.setWaittime(aiConfig.getWaittime());
//        }
//        /**
//         * 根据游戏配置 ， 选择 返回的 玩法列表
//         */
//        return new ResponseEntity<>(playerResultData, HttpStatus.OK);
        return null;
    }



}

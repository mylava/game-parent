package com.foolox.game.core.server;

import org.apache.commons.lang3.StringUtils;
import org.tio.core.Aio;
import org.tio.core.ChannelContext;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.server.handler.IWsMsgHandler;

import java.nio.ByteBuffer;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 06/05/2019
 */
public class GameEventHandler implements IWsMsgHandler {

    protected GameServer server;

    public GameServer getServer() {
        return server;
    }

    public void setServer(GameServer server) {
        this.server = server;
    }

    /**
     * 握手时走这个方法，业务可以在这里获取cookie，request参数等
     */
    public HttpResponse handshake(HttpRequest httpRequest, HttpResponse httpResponse, ChannelContext channelContext) throws Exception {
        String userid = httpRequest.getParam("userid") ;
        if(!StringUtils.isBlank(userid)) {
            channelContext.setAttribute(userid, userid);
            //绑定用户ID
            Aio.bindUser(channelContext, userid);
        }
        return httpResponse;
    }

    /**
     * 字节消息（binaryType = arraybuffer）过来后会走这个方法
     */
    public Object onBytes(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception {
        channelContext.getClientNode().getIp();
        ByteBuffer buffer = ByteBuffer.allocate(1);
        return buffer;
    }

    /**
     * 当客户端发close flag时，会走这个方法
     */
    public Object onClose(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception {
        Aio.remove(channelContext, "receive close flag");
//        BeiMiClient beiMiClient = NettyClients.getInstance().getClient(channelContext.getUserid()) ;
//        if(beiMiClient!=null){
//            /**
//             * 玩家离线
//             */
//            PlayUserClient playUserClient = (PlayUserClient) CacheHelper.getApiUserCacheBean().getCacheObject(beiMiClient.getUserid(), beiMiClient.getOrgi()) ;
//            if(playUserClient!=null){
//                if(BMDataContext.GameStatusEnum.PLAYING.toString().equals(playUserClient.getGamestatus())){
//                    GameUtils.updatePlayerClientStatus(beiMiClient.getUserid(), beiMiClient.getOrgi(), BMDataContext.PlayerTypeEnum.OFFLINE.toString());
//                }else{
//                    CacheHelper.getApiUserCacheBean().delete(beiMiClient.getUserid(), beiMiClient.getOrgi()) ;
//                    if(CacheHelper.getGamePlayerCacheBean().getPlayer(beiMiClient.getUserid(), beiMiClient.getOrgi())!=null){
//                        CacheHelper.getGamePlayerCacheBean().delete(beiMiClient.getUserid(), beiMiClient.getOrgi()) ;
//                    }
//                    CacheHelper.getRoomMappingCacheBean().delete(beiMiClient.getUserid(), beiMiClient.getOrgi()) ;
//                    /**
//                     * 玩家退出游戏，需要发送事件给所有玩家，如果房主退出，则房间解散
//                     */
//                }
//                /**
//                 * 退出房间，房卡模式下如果房间还有剩余局数 ， 则不做任何操作，如果无剩余或未开始扣卡，则删除房间
//                 */
//            }
//        }
        return null;
    }

    /**
     * 字符消息（binaryType = blob）过来后会走这个方法
     */
    public Object onText(WsRequest wsRequest, String s, ChannelContext channelContext) throws Exception {
        return null;
    }
}

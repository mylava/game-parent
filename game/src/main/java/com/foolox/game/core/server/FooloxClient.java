package com.foolox.game.core.server;

import com.foolox.game.core.engin.game.Message;
import lombok.Data;
import org.tio.core.Aio;
import org.tio.utils.json.Json;
import org.tio.websocket.common.Opcode;
import org.tio.websocket.common.WsResponse;

import java.io.IOException;
import java.io.Serializable;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 07/05/2019
 */
@Data
public class FooloxClient {
    private GameServer server;
    private String userid ;

    public void sendEvent(String event, Message msg){
        try {
            msg.setEvent(event);
            Aio.sendToUser(this.server.getServerGroupContext(), this.userid , convertToTextResponse(msg)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param body
     * @return
     * @throws IOException
     */
    private WsResponse convertToTextResponse(Serializable body) throws IOException{
        WsResponse response = new WsResponse();
        if(body != null) {
            String json = Json.toJson(body);
            response.setBody(json.getBytes("UTF-8"));
            response.setWsBodyText(json);
            response.setWsBodyLength(response.getWsBodyText().length());
            //返回text类型消息（如果这里设置成 BINARY,那么客户端就需要进行解析了）
            response.setWsOpcode(Opcode.TEXT);
        }
        return response;
    }
}

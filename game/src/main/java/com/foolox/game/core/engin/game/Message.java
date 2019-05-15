package com.foolox.game.core.engin.game;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 07/05/2019
 */
public interface Message extends java.io.Serializable {

    /**
     * 发送到客户端的指令
     * @return
     */
    public String getCommand() ;

    /**
     * 指令
     * @param command
     */
    public void setCommand(String command) ;


    /**
     * 发送到客户端的事件
     * @return
     */
    public String getEvent() ;

    /**
     * 事件
     * @param event
     */
    public void setEvent(String event) ;
}

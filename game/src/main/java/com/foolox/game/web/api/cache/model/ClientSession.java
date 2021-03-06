package com.foolox.game.web.api.cache.model;

import com.foolox.game.common.util.FooloxUtils;
import lombok.Data;

import java.util.Date;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/05/2019
 */
@Data
public class ClientSession {
    /**
     * --------------- ---------------
     * 基本信息,与房间、游戏无关
     * --------------- ---------------
     */
    private String id;
    private String token;
    private String username;
    //使用用户密码的MD5摘要，存储在客户端会话中
    private String password;
    //是否登录
    private boolean login;
    //socket是否在线
    private boolean online=false;
    //用户头像,空表示没有上传
    private String headimg;
    //会话创建时间
    private Date createtime = new Date();
    private Date updatetime = new Date();
    //最后登录时间
    private Date lastlogintime = new Date();

    /**
     * --------------- ---------------
     * 资产信息
     * --------------- ---------------
     */

    /**
     * --------------- ---------------
     * 机构相关信息
     * --------------- ---------------
     */
    //组织机构(租户)
    private String orgi;

    /**
     * --------------- ---------------
     * 游戏相关信息
     * --------------- ---------------
     */
    private String roomid;      //加入的房间ID
    private boolean roomready;  //在房间中已经准备就绪
    private String gamestatus;    //玩家在游戏中的状态 ： READY : NOTREADY : PLAYING ：MANAGED/托管
    private boolean playertype;    //玩家类型 ： 普通玩家/托管玩家/AI/离开房间玩家
    private long playerindex;   //玩家进入房间的顺序

}

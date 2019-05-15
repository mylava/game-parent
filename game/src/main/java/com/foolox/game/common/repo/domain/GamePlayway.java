package com.foolox.game.common.repo.domain;

import lombok.Data;

import java.util.Date;

/**
 * comment: 游戏玩法
 *
 * @author: lipengfei
 * @date: 11/05/2019
 */
@Data
public class GamePlayway {
    private String id;
    private String name;
    private String code;
    private Date createtime;
    private String parentid;
    private String typeid;
    private String creater;

    private int sortindex = 1;    //排序编号
    private String username;

    private String typelevel;    //初级|高级
    private String typecolor;    //玩法图标颜色

    private String status;    //当前状态

    private int score;        //底分
    private int mincoins;    //最小金币数量
    private int maxcoins;    //最大金币数量

    private boolean wind;    //有无风

    private int shuffletimes;    //洗牌次数


    private String powerful;    //癞子生成规则  ，


    private int cardsnum;    //每个玩家获牌数量

    private boolean changecard;    //换牌

    private boolean shuffle;    //是否洗牌


    private Date updatetime;
    private String orgi;
    private String area;

    private String game;    //游戏类型 ： 麻将：地主：德州
    private int players;    //游戏人数

    private int numofgames;//局数 ， 大厅游戏为 0 表示 无限

    private String wintype;//胡牌方式，推倒胡，血战 、 血流


    private String roomtype;    //房间类型， 房卡：大厅
    private String memo;        //备注信息，不超过30个字
    private boolean free;        //开启房卡限免
    private String roomtitle;    //玩法标题
    private boolean extpro;    //启用扩展属性配置（房卡游戏中的自定义规则）

    private String cardsrules;    //定义允许的出牌规则
    private String mjwinrules; //麻将允许的胡牌规则
}

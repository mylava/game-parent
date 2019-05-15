package com.foolox.game.core.engin.game;

import com.foolox.game.common.repo.domain.GamePlayway;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * comment: 瓜牛游戏
 *
 * @author: lipengfei
 * @date: 11/05/2019
 */
@Data
public class FooloxGame {

    private String id ;
    private String code ;
    private String name ;
    private List<GamePlayway> playways = new ArrayList<GamePlayway>();
}

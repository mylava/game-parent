package com.foolox.game.common.repo.mapper;

import com.foolox.game.common.repo.domain.Player;
import com.foolox.game.common.repo.domain.PlayerExample;
import java.util.List;

public interface PlayerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Player record);

    int insertSelective(Player record);

    List<Player> selectByExample(PlayerExample example);

    Player selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);
}
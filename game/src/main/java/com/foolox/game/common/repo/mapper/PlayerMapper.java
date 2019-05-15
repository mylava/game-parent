package com.foolox.game.common.repo.mapper;

import com.foolox.game.common.repo.domain.Player;
import com.foolox.game.common.repo.domain.example.PlayerExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Player record);

    int insertSelective(Player record);

    List<Player> selectByExample(PlayerExample example);

    Player selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);
}
package com.foolox.game.common.service;

import com.foolox.game.common.repo.domain.Player;
import com.foolox.game.common.repo.domain.example.PlayerExample;
import com.foolox.game.common.repo.mapper.PlayerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/05/2019
 */
@Slf4j
@Service
public class LoginService {
    @Autowired
    private PlayerMapper playerMapper;

    public Player findPlayerById(String id) {
        return playerMapper.selectByPrimaryKey(id);
    }

    public Player findPlayerByUsername(String username) {
        PlayerExample example = new PlayerExample();
        PlayerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Player> players = playerMapper.selectByExample(example);
        if (players.size()>0) {
            return players.get(0);
        }
        return null;
    }
}

package com.foolox.game.common.repo.mapper;

import com.foolox.game.common.repo.domain.SystemDict;
import com.foolox.game.common.repo.domain.example.SystemDictExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDict record);

    int insertSelective(SystemDict record);

    List<SystemDict> selectByExample(SystemDictExample example);

    SystemDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDict record);

    int updateByPrimaryKey(SystemDict record);

    /**
     * --------------- ---------------
     * 手写sql
     * --------------- ---------------
     */
    SystemDict findOneByCode(String code);


    List<SystemDict> findByParentId(Long parentId);
}
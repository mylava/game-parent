package com.foolox.game.common.repo.mapper;

import com.foolox.game.common.repo.domain.MybatisTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 07/05/2019
 */
@Mapper
@Component //此注解用于解决idea提示注入错误的bug，可以不要
public interface MybatisTestMapper {

    int insert(MybatisTest record);

    int insertSelective(MybatisTest record);

    MybatisTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MybatisTest record);

    int updateByPrimaryKeyWithBLOBs(MybatisTest record);

    int updateByPrimaryKey(MybatisTest record);

    int deleteByPrimaryKey(Long id);

    /**
     * 根据ID查询秒杀商品
     * @return
     */
    //组合查询使用vo
/*    @Select("select g.*,sg.seckill_price,sg.stock_count,sg.start_date,sg.end_date " +
            "from seckill_goods sg left join goods g on sg.goods_id = g.id " +
            "where g.id=#{goodsId}")
    GoodsVo getGoodsVoById(long goodsId);*/
}

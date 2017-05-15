package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

public interface SeckillMapper {
    int deleteByPrimaryKey(Long seckillId);

    int insert(Seckill record);

    int insertSelective(Seckill record);
    
    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill selectByPrimaryKey(Long seckillId);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);
    
    /**
     * 对于秒杀时间符合的，库存-1
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
    
    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
//    List<Seckill> queryAll(int offset, int limit);
}
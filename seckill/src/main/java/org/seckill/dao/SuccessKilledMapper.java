package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;
import org.seckill.entity.SuccessKilledKey;

public interface SuccessKilledMapper {
    int deleteByPrimaryKey(SuccessKilledKey key);

    int insert(SuccessKilled record);

    /**
     * 插入购买明细
     * @param record
     * @return
     */
    int insertSelective(SuccessKilled record);
  
    /**
     * 查询
     * @param key
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);
    
    SuccessKilled selectByPrimaryKey(SuccessKilledKey key);

    int updateByPrimaryKeySelective(SuccessKilled record);

    int updateByPrimaryKey(SuccessKilled record);
    
}
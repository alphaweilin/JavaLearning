package seckill;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillMapper;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring和junit整合
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillMapperTest {
	
	//注入Dao实现类依赖
	@Resource
	private SeckillMapper seckillDao;

	@Test
	public void testSelectByPrimaryKey() {
		long id=1000;
		Seckill seckill = seckillDao.selectByPrimaryKey(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	
	@Test
	public void testReduceNumber() {
		int cout = seckillDao.reduceNumber(1000L, new Date());
		System.out.println("count:"+cout);
	}
	
	@Test
	public void testQueryAll() {
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		System.out.println(seckills);
	}

}

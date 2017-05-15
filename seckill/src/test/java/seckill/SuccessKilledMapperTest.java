package seckill;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SuccessKilledMapper;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring和junit整合
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledMapperTest {

	//注入Dao实现类依赖
	@Resource
	private SuccessKilledMapper successKilledDao;
	
	@Test
	public void insertSelectiveTest() {
		SuccessKilled successKilled = new SuccessKilled();
		successKilled.setSeckillId(1003L);
		successKilled.setUserPhone(13462831234L);
		int insertCount = successKilledDao.insertSelective(successKilled);
		System.out.println("insertCount:"+insertCount);
	}
	
	@Test
	public void queryByIdWithSeckillTest() {
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000L, 13467831234L);
		System.out.println(successKilled);
	}

}

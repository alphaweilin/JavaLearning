package seckill;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring和junit整合,注意xml的顺序，dao.xml要写在前面先加载，因为service.xml依赖dao.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
	}
	
	@Test
	public void testGetById() {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}
	
	@Test
	public void testExportSeckillUrl() {
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}", exposer);
	}
	
	@Test
	public void testExecuteSeckill() {
		long id = 1000;
		long phone = 12131431249L;
		String md5="d306852ace042d7937a360e975962ddf";
		try {
			SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
			logger.info("result={}", execution);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		}
	}
	
	//集成测试代码完成逻辑，注意可重复执行
	@Test
	public void testSeckillLogic(){
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()){
			logger.info("exposer={}", exposer);
			long phone = 12131433249L;
			String md5=exposer.getMd5();
			try {
				SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
				logger.info("result={}", execution);
			} catch (Exception e) {
				// TODO: handle exception
				logger.error(e.getMessage(), e);
			}
		}else{
			//秒杀未开启
			logger.warn("exposer={}", exposer);
		}
		
	}

}

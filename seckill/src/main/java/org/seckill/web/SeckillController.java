package org.seckill.web;

import java.util.Date;
import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill") // url:/模块/资源/{id}/细分 /seckill/list
public class SeckillController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		// 获取列表页
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list"; // /WEB-INFO/jsp/"list".jsp
	}

	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
		if (null == seckillId) {
			return "redirect:/reskill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if (null == seckill) {
			return "forward:/reskill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	// ajax json
	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<Exposer> exposer(Long seckillId) {
		SeckillResult<Exposer> result;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			result = new SeckillResult<Exposer>(false, e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
			@PathVariable("md5") String md5, @CookieValue(value = "killPhone", required = false) Long userPhone) {

		if (null == userPhone) {
			return new SeckillResult<SeckillExecution>(false, "未注册");
		}

		SeckillResult<SeckillExecution> result;

		try {
			SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);
			result = new SeckillResult<SeckillExecution>(true, execution);
		} catch (SeckillCloseException e1) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.END);
			result = new SeckillResult<SeckillExecution>(false, execution);
		} catch (RepeatKillException e2) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.REPAET_KILL);
			result = new SeckillResult<SeckillExecution>(false, execution);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
			result = new SeckillResult<SeckillExecution>(false, execution);
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/time/now", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public SeckillResult<SeckillExecution> time() {
		Date now = new Date();
		return new SeckillResult(true, now.getTime());
	}
}

package org.tom.server.core.activity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.tom.server.basic.util.CommonConstants;
import org.tom.server.basic.util.PropertiesHandler;
import org.tom.server.core.activity.domain.ActivityInfoVO;
import org.tom.server.core.activity.service.ActivityInfoService;

@Controller
@RequestMapping(CommonConstants.URL_PREFIX)
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityInfoService activityInfoService;
	
	@RequestMapping(value = "/gainRecommandList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> gainRecommandList(
			@RequestParam(value="clubNO", required=true) String clubNO) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clubNO", clubNO);
		List<ActivityInfoVO> list = null;
		list = activityInfoService.gainRecommandListByMap(params);
		if (list == null || list.size() == 0) {
			resultMap.put("status", -1);
			resultMap.put("data", "Can't find any data!");
		} else {
			String url = PropertiesHandler.getConfigValue("url.prefix");
			resultMap.put("status", 0);
			Map<String, Object> pm = new HashMap<String, Object>();
			pm.put("url", url);
			pm.put("list", list);
			resultMap.put("data", pm);
		}
		
		return resultMap;
	}
	
	public Map<String, Object> gainRecommandDetail(
			@RequestParam(value="rcId", required=true) String rcId,
			@RequestParam(value="type", required=true) String type
			) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ("0".equals(type)) {
			
		}
		
		return resultMap;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}

}

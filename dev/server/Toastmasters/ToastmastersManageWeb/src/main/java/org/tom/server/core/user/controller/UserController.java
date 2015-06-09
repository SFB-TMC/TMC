package org.tom.server.core.user.controller;

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
import org.tom.server.basic.vo.PageJsonBean;
import org.tom.server.core.user.domain.UserInfoVO;
import org.tom.server.core.user.service.UserInfoService;

@Controller
@RequestMapping("/tmw")
public class UserController extends AbstractController {
	
	/** Used in pagination **/
	public PageJsonBean jsonBean = new PageJsonBean();
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * jump to user page
	 * @return
	 */
	@RequestMapping("user")
	public String userlink() {
		
		return "user";
	}
	
	/**
	 * show user list
	 * @return
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userlist(
			@RequestParam(value="pageNum", required=true) int pageNum,
			@RequestParam(value="pageCount", required=true) int pageCount,
			@RequestParam(value="searchCondition", required=true) String searchCondition) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchCondition", searchCondition);
		List<UserInfoVO> list = userInfoService.queryUserInfoByMap(map, pageNum, pageCount);
		int counts = userInfoService.queryUserInfoCountByMap(map);
		Map<String, Object> model = new HashMap<String, Object>(2);  
		model.put("pageNum", pageNum); 
		model.put("pageCount", pageCount); 
		model.put("total", counts); 
		model.put("list", list); 
		
		return model;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}
	
}

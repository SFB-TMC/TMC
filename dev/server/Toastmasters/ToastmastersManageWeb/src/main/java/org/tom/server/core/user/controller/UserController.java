package org.tom.server.core.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.tom.server.basic.util.SessionConstants;
import org.tom.server.basic.vo.PageJsonBean;
import org.tom.server.core.menu.domain.MenuInfoVO;
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
	@RequestMapping("/menu/user")
	public String userlink(Map<String, Object> model, HttpSession httpSession) {
		
		@SuppressWarnings("unchecked")
		List<MenuInfoVO> list = (ArrayList<MenuInfoVO>)httpSession.getAttribute(SessionConstants.MENU_SESSION_ID);
		UserInfoVO userInfo = (UserInfoVO)httpSession.getAttribute(SessionConstants.LOGIN_SESSION_ID);
		model.put("menuList", list);
		model.put("userInfo", userInfo);
		
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
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public String userinfo(Map<String, Object> model) {
		
		return null;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}
	
}

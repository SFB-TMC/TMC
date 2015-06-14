package org.tom.server.core.index.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.tom.server.basic.util.CommonTools;
import org.tom.server.basic.util.EncryptPwd;
import org.tom.server.basic.util.SessionConstants;
import org.tom.server.core.index.domain.LoginLogVO;
import org.tom.server.core.index.service.IndexService;
import org.tom.server.core.menu.domain.MenuInfoVO;
import org.tom.server.core.menu.service.MenuInfoService;
import org.tom.server.core.user.domain.UserInfoVO;

@Controller
@RequestMapping("/tmw")
public class IndexController extends AbstractController {
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private MenuInfoService menuInfoService;
	
	@RequestMapping("/index")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping("/menu/home")
	public String home(Map<String, Object> model, HttpSession httpSession) {
		
		@SuppressWarnings("unchecked")
		List<MenuInfoVO> list = (ArrayList<MenuInfoVO>)httpSession.getAttribute(SessionConstants.MENU_SESSION_ID);
		UserInfoVO userInfo = (UserInfoVO)httpSession.getAttribute(SessionConstants.LOGIN_SESSION_ID);
		model.put("menuList", list);
		model.put("userInfo", userInfo);
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password, 
			HttpSession httpSession, HttpServletRequest request) {
		
		// Encrypt password
		String encryptPwd = EncryptPwd.encrypt(password);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", encryptPwd);
		
		UserInfoVO vo = indexService.queryUserInfoByMap(map);
		Map<String, Object> model = new HashMap<String, Object>(2);  
		model.put("success", "true"); 
		if (vo != null) {
			model.put("res", "true");
			// SAVE THE SESSION
			httpSession.setAttribute(SessionConstants.LOGIN_SESSION_ID, vo);
			List<MenuInfoVO> list = CommonTools.queryMenuInfo(menuInfoService, username);
			httpSession.setAttribute(SessionConstants.MENU_SESSION_ID, list);
			// SAVE THE LOGIN LOG
			String loginIp = request.getRemoteHost();
			Date date = new Date();
			String device = "PC";
			int status = 0;
			LoginLogVO llvo = new LoginLogVO();
			llvo.setDevice(device);
			llvo.setLoginIp(loginIp);
			llvo.setLoginName(username);
			llvo.setLoginTime(date);
			llvo.setStatus(status);
			// insert log
			indexService.insertLoginLog(llvo);
			
			return model;
		} else {
			model.put("res", "false");  
			return model;
		}
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		return null;
	}
}

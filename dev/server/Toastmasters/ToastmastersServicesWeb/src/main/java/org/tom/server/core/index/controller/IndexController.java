package org.tom.server.core.index.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.tom.server.basic.util.CommonConstants;
import org.tom.server.basic.util.EncryptPwd;
import org.tom.server.core.index.domain.LoginLogVO;
import org.tom.server.core.index.service.IndexService;
import org.tom.server.core.user.domain.UserInfoVO;

@Controller
@RequestMapping(CommonConstants.URL_PREFIX)
public class IndexController extends AbstractController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping("/index")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password, 
			@RequestParam(value="device", required=true) String device, 
			HttpSession httpSession, HttpServletRequest request) {
		
		// Encrypt password
		String encryptPwd = EncryptPwd.encrypt(password);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", encryptPwd);
		
		UserInfoVO userInfoVO = indexService.queryUserInfoByMap(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (userInfoVO != null) {
			resultMap.put("status", 0);
			resultMap.put("data", userInfoVO);
			
			String loginIp = request.getRemoteHost();
			Date date = new Date();
			int status = 0;
			LoginLogVO llvo = new LoginLogVO();
			llvo.setDevice(device);
			llvo.setLoginIp(loginIp);
			llvo.setLoginName(username);
			llvo.setLoginTime(date);
			llvo.setStatus(status);
			// insert log
			indexService.insertLoginLog(llvo);
		} else {
			resultMap.put("status", -1);
			resultMap.put("data", "Can't find any data!");
		}
		
		return resultMap;
	}
	
	/**
	 * bind the prefix 'user.'
	 * @param binder
	 */
	@InitBinder("user")    
    public void initBinder(WebDataBinder binder) {    
		
		binder.setFieldDefaultPrefix("user.");    
    }  
	
	/**
	 * Update user information
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public boolean updateUserInfo(@ModelAttribute UserInfoVO user) {
		
		boolean res = indexService.updateUserInfo(user);
		
		return res;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		return null;
	}
}

package org.tom.server.core.index.controller;

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
import org.tom.server.basic.util.EncryptPwd;
import org.tom.server.core.index.service.IndexService;
import org.tom.server.core.user.domain.UserInfoVO;

@Controller
@RequestMapping("/tmw")
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
			@RequestParam(value="password", required=true) String password, HttpSession httpSession) {
		
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
		} else {
			resultMap.put("status", -1);
			resultMap.put("data", "µ«¬º ß∞‹£¨«ÎºÏ≤È”√ªß√˚√‹¬Î£°");
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

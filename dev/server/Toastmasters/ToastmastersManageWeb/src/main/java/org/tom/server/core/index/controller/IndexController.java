package org.tom.server.core.index.controller;

import java.util.HashMap;
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
import org.tom.server.basic.util.CommonConstants;
import org.tom.server.basic.util.EncryptPwd;
import org.tom.server.core.index.service.IndexService;

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
		
		boolean res = indexService.queryUserInfoByMap(map);
		Map<String, Object> model = new HashMap<String, Object>(2);  
		model.put("success", "true"); 
		if (res) {
			model.put("res", "true");
			// SAVE THE SESSION
			httpSession.setAttribute(CommonConstants.LOGIN_SESSION_ID, username);
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

package org.tom.server.core.code.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.tom.server.core.code.service.CodeLibraryService;

@Controller
@RequestMapping("/tmw")
public class CodeLibraryController extends AbstractController {
	
	@Autowired
	private CodeLibraryService codeLibraryService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * gain role list
	 * @return
	 */
	@RequestMapping(value = "/rolelist", method = RequestMethod.POST)
	public Map<String, Object> rolelist(HttpSession httpSession) {
		
		return null;
	}
}

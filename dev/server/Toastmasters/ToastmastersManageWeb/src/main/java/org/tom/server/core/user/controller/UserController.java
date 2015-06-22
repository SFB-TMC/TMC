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
import org.tom.server.core.club.domain.ClubInfoVO;
import org.tom.server.core.club.service.ClubInfoService;
import org.tom.server.core.code.domain.CodeLibraryVO;
import org.tom.server.core.code.service.CodeLibraryService;
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
	
	@Autowired
	private CodeLibraryService codeLibraryService;
	
	@Autowired
	private ClubInfoService clubInfoService;
	
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
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public String userinfo(Map<String, Object> model, HttpSession httpSession) {
		
		// Gain the user information
		UserInfoVO userInfo = (UserInfoVO)httpSession.getAttribute(SessionConstants.LOGIN_SESSION_ID);
		String curRoleCode = userInfo.getRoleCode(); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleCode", curRoleCode);
		List<CodeLibraryVO> roleList = codeLibraryService.queryRoleInfoByMap(map);
		List<CodeLibraryVO> officerList = codeLibraryService.queryOfficerListByMap(map);
		List<CodeLibraryVO> areaList = codeLibraryService.queryAreaListByMap(map);
		map.clear();
		List<ClubInfoVO> clubList = clubInfoService.queryClubInfoListByMap(map);
		if (roleList == null) {
			roleList = new ArrayList<CodeLibraryVO>();
		}
		if (officerList == null) {
			officerList = new ArrayList<CodeLibraryVO>();
		}
		if (areaList == null) {
			areaList = new ArrayList<CodeLibraryVO>();
		}
		if (clubList == null) {
			clubList = new ArrayList<ClubInfoVO>();
		}
		
		model.put("roleList", roleList);
		model.put("officerList", officerList);
		model.put("areaList", areaList);
		model.put("clubList", clubList);
		
		return "userInfo";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}
	
}

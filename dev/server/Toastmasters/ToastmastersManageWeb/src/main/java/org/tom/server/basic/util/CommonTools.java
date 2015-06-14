package org.tom.server.basic.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tom.server.core.menu.domain.MenuInfoVO;
import org.tom.server.core.menu.service.MenuInfoService;

public class CommonTools {
	
	/**
	 * query menu information
	 * @param loginName
	 * @return
	 */
	public static List<MenuInfoVO> queryMenuInfo(MenuInfoService menuInfoService, String loginName) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginName", loginName);
		List<MenuInfoVO> list = menuInfoService.queryMenuInfoByMap(map);
		return list;
	}
}

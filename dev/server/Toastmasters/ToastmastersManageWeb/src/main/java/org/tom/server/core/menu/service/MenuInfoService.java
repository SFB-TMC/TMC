package org.tom.server.core.menu.service;

import java.util.List;
import java.util.Map;

import org.tom.server.core.menu.domain.MenuInfoVO;

public interface MenuInfoService {

	/**
	 * search menu information
	 * @param map
	 * @return
	 */
	List<MenuInfoVO> queryMenuInfoByMap(Map<String, Object> map);
}

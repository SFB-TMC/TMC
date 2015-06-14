package org.tom.server.core.menu.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.tom.server.core.menu.domain.MenuInfoVO;

public interface MenuInfoMapper {

	/**
	 * search menu information
	 * @param map
	 * @return
	 */
	List<MenuInfoVO> queryMenuInfoByMap(Map<String, Object> map) throws SQLException;
}

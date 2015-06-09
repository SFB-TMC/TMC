package org.tom.server.core.index.service;

import java.sql.SQLException;
import java.util.Map;

public interface IndexService {

	/**
	 * 查询用户信息
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	boolean queryUserInfoByMap(Map<String, Object> map);
}

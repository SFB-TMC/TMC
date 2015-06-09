package org.tom.server.core.index.mapper;

import java.sql.SQLException;
import java.util.Map;

/**
 * User Mapper
 * @author yellowshuo
 */
public interface IndexMapper {

	/**
	 * 查询用户信息
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	int queryUserInfoByMap(Map<String, Object> map) throws SQLException;
}

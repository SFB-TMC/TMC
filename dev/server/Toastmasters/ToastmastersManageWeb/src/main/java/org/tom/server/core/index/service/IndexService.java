package org.tom.server.core.index.service;

import java.sql.SQLException;
import java.util.Map;

public interface IndexService {

	/**
	 * ��ѯ�û���Ϣ
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	boolean queryUserInfoByMap(Map<String, Object> map);
}

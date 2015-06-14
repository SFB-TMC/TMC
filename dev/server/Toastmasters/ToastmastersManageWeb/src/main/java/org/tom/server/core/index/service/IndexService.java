package org.tom.server.core.index.service;

import java.sql.SQLException;
import java.util.Map;

import org.tom.server.core.index.domain.LoginLogVO;
import org.tom.server.core.user.domain.UserInfoVO;

public interface IndexService {

	/**
	 * search user information
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	UserInfoVO queryUserInfoByMap(Map<String, Object> map);
	
	/**
	 * save the login log
	 * @param loginLogVO
	 * @throws SQLException
	 */
	boolean insertLoginLog(LoginLogVO loginLogVO);
}

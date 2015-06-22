package org.tom.server.core.index.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.tom.server.core.index.domain.LoginLogVO;
import org.tom.server.core.user.domain.UserInfoVO;

/**
 * User Mapper
 * @author yellowshuo
 */
public interface IndexMapper {

	/**
	 * query user information
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	UserInfoVO queryUserInfoByMap(Map<String, Object> map) throws SQLException;
	
	/**
	 * update user information
	 * @param userInfoVO
	 * @return
	 */
	void updateUserInfo(UserInfoVO userInfoVO) throws SQLException;
	
	/**
	 * save the login log
	 * @param loginLogVO
	 * @throws SQLException
	 */
	void insertLoginLog(LoginLogVO loginLogVO) throws SQLException;
}

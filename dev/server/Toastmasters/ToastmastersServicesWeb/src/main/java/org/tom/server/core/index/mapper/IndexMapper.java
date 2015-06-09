package org.tom.server.core.index.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.tom.server.core.user.domain.UserInfoVO;

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
	UserInfoVO queryUserInfoByMap(Map<String, Object> map) throws SQLException;
	
	/**
	 * update user information
	 * @param userInfoVO
	 * @return
	 */
	void updateUserInfo(UserInfoVO userInfoVO) throws SQLException;
}

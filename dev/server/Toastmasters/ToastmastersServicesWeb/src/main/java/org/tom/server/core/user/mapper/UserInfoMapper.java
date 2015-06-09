package org.tom.server.core.user.mapper;

import java.util.List;
import java.util.Map;

import org.tom.server.core.user.domain.UserInfoVO;

public interface UserInfoMapper {

	/**
	 * query user information
	 * @param map
	 * @return
	 */
	List<UserInfoVO> queryUserInfoByMap(Map<String, Object> map);
	
	/**
	 * query user count
	 * @param map
	 * @return
	 */
	int queryUserInfoCountByMap(Map<String, Object> map);
}

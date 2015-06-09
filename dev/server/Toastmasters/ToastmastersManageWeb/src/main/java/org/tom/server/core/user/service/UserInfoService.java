package org.tom.server.core.user.service;

import java.util.List;
import java.util.Map;

import org.tom.server.core.user.domain.UserInfoVO;

public interface UserInfoService {

	/**
	 * search user information by search condition
	 * @param map
	 * @param pageNum
	 * @param pageCount
	 * @return
	 */
	List<UserInfoVO> queryUserInfoByMap(Map<String, Object> map, Integer pageNum, Integer pageCount);
	
	/**
	 * search user count by search condition
	 * @param map
	 * @return
	 */
	int queryUserInfoCountByMap(Map<String, Object> map);
}

package org.tom.server.core.club.service;

import java.util.List;
import java.util.Map;

import org.tom.server.core.club.domain.ClubInfoVO;

public interface ClubInfoService {

	/**
	 * query club information
	 * @param map
	 * @return
	 */
	List<ClubInfoVO> queryClubInfoListByMap(Map<String, Object> map);
}

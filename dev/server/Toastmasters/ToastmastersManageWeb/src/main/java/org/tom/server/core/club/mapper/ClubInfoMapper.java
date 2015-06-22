package org.tom.server.core.club.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.tom.server.core.club.domain.ClubInfoVO;

public interface ClubInfoMapper {

	/**
	 * query club information
	 * @param map
	 * @return
	 */
	List<ClubInfoVO> queryClubInfoListByMap(Map<String, Object> map) throws SQLException;
}

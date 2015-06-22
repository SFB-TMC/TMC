package org.tom.server.core.activity.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.tom.server.core.activity.domain.ActivityInfoVO;

public interface ActivityInfoMapper {

	/**
	 * gain recommand list
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	List<ActivityInfoVO> gainRecommandListByMap(Map<String, Object> map) throws SQLException;
}

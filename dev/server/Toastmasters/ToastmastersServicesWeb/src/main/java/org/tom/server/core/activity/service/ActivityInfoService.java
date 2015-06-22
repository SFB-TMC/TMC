package org.tom.server.core.activity.service;

import java.util.List;
import java.util.Map;

import org.tom.server.core.activity.domain.ActivityInfoVO;

public interface ActivityInfoService {

	/**
	 * gain recommand list
	 * @param map
	 * @return
	 */
	List<ActivityInfoVO> gainRecommandListByMap(Map<String, Object> map);
}

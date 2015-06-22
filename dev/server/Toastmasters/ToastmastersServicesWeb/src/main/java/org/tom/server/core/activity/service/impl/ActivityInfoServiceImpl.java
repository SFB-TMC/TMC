package org.tom.server.core.activity.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tom.server.core.activity.domain.ActivityInfoVO;
import org.tom.server.core.activity.mapper.ActivityInfoMapper;
import org.tom.server.core.activity.service.ActivityInfoService;
import org.tom.server.core.code.mapper.CodeLibraryMapper;

@Service("activityInfoService")
@Transactional(rollbackFor = Exception.class)
public class ActivityInfoServiceImpl implements ActivityInfoService {
	
	@Autowired
	private ActivityInfoMapper activityInfoMapper;
	
	@Autowired
	private CodeLibraryMapper codeLibraryMapper;

	private Log logger = LogFactory.getLog(ActivityInfoServiceImpl.class);
	
	public List<ActivityInfoVO> gainRecommandListByMap(Map<String, Object> map) {
		
		List<ActivityInfoVO> list = null;
		
		try {
			// Get the list count
			int count = codeLibraryMapper.gainRecommandListCount();
			map.put("count", count);
			list = activityInfoMapper.gainRecommandListByMap(map);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			return null;
		}
		
		return list;
	}
}

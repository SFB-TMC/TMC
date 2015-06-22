package org.tom.server.core.club.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tom.server.core.club.domain.ClubInfoVO;
import org.tom.server.core.club.mapper.ClubInfoMapper;
import org.tom.server.core.club.service.ClubInfoService;

@Service("clubInfoService")
@Transactional(rollbackFor = Exception.class)
public class ClubInfoServiceImpl implements ClubInfoService {
	
	@Autowired
	private ClubInfoMapper clubInfoMapper;
	
	private Log logger = LogFactory.getLog(ClubInfoServiceImpl.class);

	public List<ClubInfoVO> queryClubInfoListByMap(Map<String, Object> map) {
		
		List<ClubInfoVO> list = null;
		try {
			list = clubInfoMapper.queryClubInfoListByMap(map);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			return null;
		}
		
		return list;
	}

}

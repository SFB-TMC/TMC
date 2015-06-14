package org.tom.server.core.index.service.impl;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tom.server.core.index.domain.LoginLogVO;
import org.tom.server.core.index.mapper.IndexMapper;
import org.tom.server.core.index.service.IndexService;
import org.tom.server.core.user.domain.UserInfoVO;

@Service("indexService")
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {
	
	private Log logger = LogFactory.getLog(IndexServiceImpl.class);
	
	@Autowired
	private IndexMapper indexMapper;

	public UserInfoVO queryUserInfoByMap(Map<String, Object> map) {
		
		logger.info("Start Query Login Info...");
		try {
			UserInfoVO vo = indexMapper.queryUserInfoByMap(map);
			if (vo == null) {
				logger.info("Couldn't find any login info...");
				logger.info("End Query Login Info...");
				return null;
			} else {
				logger.info("End Query Login Info...");
				return vo;
			}
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
			logger.info("End Query Login Info...");
			return null;
		}
	}

	public boolean insertLoginLog(LoginLogVO loginLogVO) {
		
		try {
			indexMapper.insertLoginLog(loginLogVO);
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
			return false;
		}
		
		return true;
	}
}

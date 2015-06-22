package org.tom.server.core.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tom.server.core.user.domain.UserInfoVO;
import org.tom.server.core.user.mapper.UserInfoMapper;
import org.tom.server.core.user.service.UserInfoService;

@Service("userInfoService")
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	private Log logger = LogFactory.getLog(UserInfoServiceImpl.class);
	
	public List<UserInfoVO> queryUserInfoByMap(Map<String, Object> map,
			Integer pageNum, Integer pageCount) {
		
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		
		list = sqlSessionTemplate.selectList("org.tom.server.core.user.mapper.UserInfoMapper.queryUserInfoByMap", 
				map, new RowBounds((pageNum-1) * pageCount, pageCount));
		if(list != null && list.size() > 0) {
			return list;
		}
		
		logger.error("can not query any data!");
		return null;
	}

	public int queryUserInfoCountByMap(Map<String, Object> map) {
		
		int count = userInfoMapper.queryUserInfoCountByMap(map);
		
		if (count == 0) {
			logger.error("can not query any data!");
		}
		return count;
	}
}

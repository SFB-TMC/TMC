package org.tom.server.core.menu.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tom.server.core.menu.domain.MenuInfoVO;
import org.tom.server.core.menu.mapper.MenuInfoMapper;
import org.tom.server.core.menu.service.MenuInfoService;

@Service("menuInfoService")
@Transactional(rollbackFor = Exception.class)
public class MenuInfoServiceImpl implements MenuInfoService {
	
	@Autowired
	private MenuInfoMapper menuInfoMapper;

	public List<MenuInfoVO> queryMenuInfoByMap(Map<String, Object> map) {
		
		List<MenuInfoVO> list = null;
		try {
			list = menuInfoMapper.queryMenuInfoByMap(map);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return list;
	}

}

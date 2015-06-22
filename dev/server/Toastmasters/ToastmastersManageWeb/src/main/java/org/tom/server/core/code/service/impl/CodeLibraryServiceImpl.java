package org.tom.server.core.code.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tom.server.core.code.domain.CodeLibraryVO;
import org.tom.server.core.code.mapper.CodeLibraryMapper;
import org.tom.server.core.code.service.CodeLibraryService;

@Service("codeLibraryService")
@Transactional(rollbackFor = Exception.class)
public class CodeLibraryServiceImpl implements CodeLibraryService {
	
	@Autowired
	private CodeLibraryMapper codeLibraryMapper;

	private Log logger = LogFactory.getLog(CodeLibraryServiceImpl.class);
	
	public List<CodeLibraryVO> queryRoleInfoByMap(Map<String, Object> map) {

		List<CodeLibraryVO> list = null;
		try {
			list = codeLibraryMapper.queryRoleInfoByMap(map);
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
		
		return list;
	}

	public List<CodeLibraryVO> queryOfficerListByMap(Map<String, Object> map) {
		
		List<CodeLibraryVO> list = null;
		try {
			list = codeLibraryMapper.queryOfficerListByMap(map);
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
		
		return list;
	}

	public List<CodeLibraryVO> queryAreaListByMap(Map<String, Object> map) {
		
		List<CodeLibraryVO> list = null;
		try {
			list = codeLibraryMapper.queryAreaListByMap(map);
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
		
		return list;
	}

}

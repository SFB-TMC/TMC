package org.tom.server.core.code.service;

import java.util.List;
import java.util.Map;

import org.tom.server.core.code.domain.CodeLibraryVO;

public interface CodeLibraryService {

	/**
	 * query role information list
	 * @param map
	 * @return
	 */
	List<CodeLibraryVO> queryRoleInfoByMap(Map<String, Object> map);
	
	/**
	 * query officer information list
	 * @param map
	 * @return
	 */
	List<CodeLibraryVO> queryOfficerListByMap(Map<String, Object> map);
	
	/**
	 * query area information list
	 * @param map
	 * @return
	 */
	List<CodeLibraryVO> queryAreaListByMap(Map<String, Object> map);
}

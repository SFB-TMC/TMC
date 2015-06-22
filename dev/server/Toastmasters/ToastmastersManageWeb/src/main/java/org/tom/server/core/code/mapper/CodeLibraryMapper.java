package org.tom.server.core.code.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.tom.server.core.code.domain.CodeLibraryVO;

public interface CodeLibraryMapper {

	/**
	 * query role information list
	 * @param map
	 * @return
	 */
	List<CodeLibraryVO> queryRoleInfoByMap(Map<String, Object> map) throws SQLException;
	
	/**
	 * query officer information list
	 * @param map
	 * @return
	 */
	List<CodeLibraryVO> queryOfficerListByMap(Map<String, Object> map) throws SQLException;
	
	/**
	 * query area information list
	 * @param map
	 * @return
	 */
	List<CodeLibraryVO> queryAreaListByMap(Map<String, Object> map) throws SQLException;
}

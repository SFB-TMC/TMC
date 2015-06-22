package org.tom.server.core.code.mapper;

import java.sql.SQLException;

public interface CodeLibraryMapper {

	/**
	 * Gain Recommand List Count
	 * @return
	 * @throws SQLException
	 */
	int gainRecommandListCount() throws SQLException;
}

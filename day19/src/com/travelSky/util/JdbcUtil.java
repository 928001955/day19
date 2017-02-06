package com.travelSky.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {

	private static DataSource dS = new ComboPooledDataSource();

	/**
	 * 获取连接池对象的方法
	 */
	public static DataSource getDataSource() {
		return dS;
	}
}

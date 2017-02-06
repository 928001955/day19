package com.travelSky.dao;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.travelSky.entity.Employee;
import com.travelSky.util.JdbcUtil;

/**
 * 员工Dao
 * @author pc
 *
 */
public class EmpDao {
	/**
	 * 查询当前页员工数据
	 * @throws SQLException 
	 */
	public List<Employee> queryData(int currentPage,int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="SELECT  * FROM employee LIMIT ?,?";
		int start=(currentPage-1)*pageSize;
		List<Employee> list = (List<Employee>)qr.query(sql, new BeanListHandler(Employee.class),new Object[]{start,pageSize});
		return list;
	}
	/**
	 * 提供一个查询总记录数的方法
	 * @throws SQLException 
	 * 
	 */
	public int  queryCount() throws SQLException {
		String sql = "select count(*) from employee";
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		Long count=(Long) qr.query(sql, new ScalarHandler());
		return count.intValue();
	}
}

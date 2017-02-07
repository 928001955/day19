package com.travelSky.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.travelSky.dao.EmpDao;
import com.travelSky.entity.Employee;
import com.travelSky.entity.PageBean;

/**
 * 员工的service层
 * 
 * @author pc
 *
 */
public class EmpService {

	/**
	 * 提供一个封装好的PageBean
	 * 
	 * @param request
	 * @return
	 */
	
	EmpDao dao = new EmpDao();
	
	public PageBean getPageBean(Integer currentPage) {

		PageBean pageBean = new PageBean();
		
		pageBean.setCurrentPage(currentPage);

		pageBean.setPageSize(5);

		try {
			pageBean.setTotalCount(dao.queryCount());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		List<Employee> list = null;
		try {
			list = dao.queryData(pageBean.getCurrentPage(), pageBean.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageBean.setData(list);

		return pageBean;
	}
}

package com.travelSky.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travelSky.dao.EmpDao;
import com.travelSky.entity.Employee;
import com.travelSky.entity.PageBean;
import com.travelSky.service.EmpService;

public class ListEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Test1(request, response);

		// Test2(request, response);

		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		EmpService service = new EmpService();
		PageBean pageBean = service.getPageBean(Integer.parseInt(currentPage));

		// 把PageBean对象放入域对象中
		request.setAttribute("pageBean", pageBean);
		// 转发到jsp页面中显示数据
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}

	
	
	
	
	
	
	private void Test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageBean pageBean = new PageBean();

		String currentPage = request.getParameter("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		pageBean.setPageSize(5);

		EmpDao dao = new EmpDao();

		try {
			pageBean.setTotalCount(dao.queryCount());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		List<Employee> list = null;
		try {
			list = dao.queryData(pageBean.getCurrentPage(), pageBean.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageBean.setData(list);

		// 2)把PageBean对象放入域对象中
		request.setAttribute("pageBean", pageBean);
		// 3)转发到jsp页面中显示数据
		request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	}

	/*
	 * private void Test1(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // 1)封装PageBean对象
	 * PageBean pageBean = new PageBean();
	 * 
	 * // 1.1 List<Employee> list = new ArrayList<Employee>(); for (int i = 0; i
	 * < 5; i++) { list.add(new Employee(i, "张三" + i, "男", "软件开发工程师", "92800195"
	 * + i + "@qq.com", 4400.00 + i)); }
	 * 
	 * pageBean.setData(list);
	 * 
	 * // 1.2 pageBean.setFirstPage(1); // 1.3 String currentPage =
	 * request.getParameter("currentPage"); if (currentPage == null ||
	 * currentPage.equals("")) { currentPage = "1"; }
	 * pageBean.setCurrentPage(Integer.parseInt(currentPage));
	 * 
	 * // 1.4 if (pageBean.getCurrentPage() == pageBean.getFirstPage()) {
	 * pageBean.setPrePage(1); } else {
	 * pageBean.setPrePage(pageBean.getCurrentPage() - 1); } // 1.5
	 * pageBean.setTotalCount(21); // 1.6 pageBean.setPageSize(5); // 1.7
	 * pageBean.setTotalPage(pageBean.getTotalCount() % pageBean.getPageSize()
	 * == 0 ? pageBean.getTotalCount() / pageBean.getPageSize() :
	 * pageBean.getTotalCount() / pageBean.getPageSize() + 1); // 1.8 if
	 * (pageBean.getCurrentPage() == pageBean.getTotalPage()) {
	 * pageBean.setNextPage(pageBean.getTotalPage()); } else {
	 * pageBean.setNextPage(pageBean.getCurrentPage() + 1); }
	 * 
	 * // 2)把PageBean对象放入域对象中 request.setAttribute("pageBean", pageBean); //
	 * 3)转发到jsp页面中显示数据
	 * request.getRequestDispatcher("/listEmp.jsp").forward(request, response);
	 * }
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

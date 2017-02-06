<%@page import="com.travelSky.entity.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>分页查询员工数据</title>
</head>

<body>
	<table border="1" align="center" width="700px">
		<tr>
			<th>编号:</th>
			<th>姓名:</th>
			<th>性别:</th>
			<th>职位:</th>
			<th>邮箱:</th>
			<th>薪水:</th>
		</tr>

		<c:forEach items="${pageBean.data}" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.gender }</td>
				<td>${emp.title }</td>
				<td>${emp.email}</td>
				<td>${emp.salary}</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center" colspan="6"><a
				href="${pageContext.request.contextPath }/ListEmpServlet?currentPage=${pageBean.firstPage }">
					首页 </a>&nbsp; <a
				href="${pageContext.request.contextPath}/ListEmpServlet?currentPage=${pageBean.prePage}">上一页</a>&nbsp;
				<a
				href="${pageContext.request.contextPath}/ListEmpServlet?currentPage=${pageBean.nextPage}">下一页</a>&nbsp;
				<a
				href="${pageContext.request.contextPath}/ListEmpServlet?currentPage=${pageBean.totalPage}"">末页</a>&nbsp;
				当前页${pageBean.currentPage }/${pageBean.totalPage}&nbsp;
				共${pageBean.totalCount}条数据&nbsp; 每页显示${pageBean.pageSize}条</td>
		</tr>
	</table>
</body>
</html>

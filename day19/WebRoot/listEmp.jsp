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
			<td align="center" colspan="6">
			<c:choose>
					<c:when test="${pageBean.currentPage==pageBean.firstPage }">
						首页&nbsp;
						上一页 
					</c:when>
					
					<c:otherwise>
						<a href="${pageContext.request.contextPath }/ListEmpServlet?currentPage=${pageBean.firstPage}&pageSize=${pageBean.pageSize}">
							首页 </a>&nbsp;
					    <a href="${pageContext.request.contextPath}/ListEmpServlet?currentPage=${pageBean.prePage}&pageSize=${pageBean.pageSize}">上一页</a>&nbsp;
					</c:otherwise>
			</c:choose> 
			
			<c:choose>
				<c:when test="${pageBean.currentPage==pageBean.totalPage }">
					下一页&nbsp;
					末页
				</c:when>
				
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/ListEmpServlet?currentPage=${pageBean.nextPage}&pageSize=${pageBean.pageSize}">下一页</a>&nbsp;
					<a href="${pageContext.request.contextPath}/ListEmpServlet?currentPage=${pageBean.totalPage}&pageSize=${pageBean.pageSize}">末页</a>&nbsp;
				</c:otherwise>
			</c:choose>
				
				当前页${pageBean.currentPage }/${pageBean.totalPage}&nbsp;
				共${pageBean.totalCount}条数据&nbsp; 
				每页显示<input id="pageSize" type="text" size="2" value="${pageBean.pageSize }" onblur="changePageSize()"/>条
				跳转到<input id="curPage" type="text" size="2" " onblur="changePage()"/>页
				</td>
		</tr>
	</table>
</body>

<script type="text/javascript">
	function changePageSize(){
		var pageSize = document.getElementById("pageSize").value;
		var reg=/^[1-9][0-9]?$/;
		if(reg.test(pageSize)){
			alert("只能输入1-2位的数字");
			return;
		}
		
		var url="${pageContext.request.contextPath}/ListEmpServlet?pageSize="+pageSize;
		window.location.href=url;
	}
	
	function changePage(){
		var curPage = document.getElementById("curPage").value;
		var reg=/^[1-9][0-9]?$/;
		if(reg.test(pageSize)){
			alert("只能输入1-2位的数字");
			return;
		}
		var totalPage="${pageBean.totalPage}";
		if(curPage>totalPage){
			alert("超过最大页数");
			return;
		}
		var url="${pageContext.request.contextPath}/ListEmpServlet?currentPage="+curPage+"&pageSize=${pageBean.pageSize}";
		window.location.href=url;
	}
</script>
</html>

package com.travelSky.entity;

import java.util.List;

/**
 * 分页对象,用于存贮当前页分页数据
 */
public class PageBean {
	List<Employee> data; // 当前页数据
	int firstPage; // 首页页码
	int prePage;// 上一页页码
	int nextPage;// 下一页页码
	int totalPage;// 末页页码
	int currentPage;// 当前页页码
	int totalCount;// 总记录数
	int pageSize;// 每页显示记录数

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

	public int getFirstPage() {
		return 1;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		return this.getCurrentPage() == this.getFirstPage() ? this.getFirstPage() : this.getCurrentPage() - 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return this.getCurrentPage() == this.getTotalPage() ? this.getTotalPage() : this.getCurrentPage() + 1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return this.getTotalCount() % this.getPageSize() == 0 ? this.getTotalCount() / this.getPageSize()
				: this.getTotalCount() / this.getPageSize() + 1;
	}
	
	public void setTotalPage(int s) {
		this.totalPage=s;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}

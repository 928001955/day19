package com.travelSky.iface;

import java.util.List;

import com.travelSky.entity.Employee;

public interface EmpInterface {
	public List<Employee> queryData(int currentPage,int pageSize);
	public int  queryCount();
}

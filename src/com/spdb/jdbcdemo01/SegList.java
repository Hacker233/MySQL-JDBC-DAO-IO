package com.spdb.jdbcdemo01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SegList {
	private List<EmployeesVo> newList = new ArrayList<EmployeesVo>();
	
	ReadEmployessTxt oldList = new ReadEmployessTxt();
	
	public List<EmployeesVo> segOldList() throws IOException {
		int size = oldList.readEmployessList().size();
		for(int i=0;i <  size;i++) {
			String[] listLine = oldList.readEmployessList().get(i).split("\\|");
			EmployeesVo employeesVo = new EmployeesVo(Integer.parseInt(listLine[0]),listLine[1],listLine[2],Integer.parseInt(listLine[3]),listLine[4],listLine[5],listLine[6]);
			newList.add(employeesVo);
		}
		return newList;
	}
}

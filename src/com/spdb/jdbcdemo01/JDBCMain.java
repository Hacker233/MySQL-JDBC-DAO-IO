package com.spdb.jdbcdemo01;

import java.util.List;

public class JDBCMain {

	public static void main(String[] args) throws Exception {
		//声明数据库操作对象
		EmployessDAO employessDAO = new EmployessDAO();
		//声明文件写入对象
		WriteSelectFile writeSelectFile = new WriteSelectFile();
		
		//读取文件并将每行数据存入一个list集合中去
		ReadEmployessTxt readEmployessTxt = new ReadEmployessTxt();
		readEmployessTxt.readEmployessList();
		
		//分割字符串并利用EmployeesVo复制存入一个对象集合list中去
		SegList segList = new SegList();
		
		//查询数据，将查询到的数据存到list集合中去
		List<EmployeesVo> selectList = employessDAO.selectEmployees("20190715", "m");
		//将查询到的数据写入文件filtered.txt
		writeSelectFile.writeFile(selectList);
		
		//声明一个新的对象集合
		List<EmployeesVo> list = segList.segOldList();
		//插入数据
		employessDAO.insert(list);
	}

}

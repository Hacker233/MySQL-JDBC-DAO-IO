package com.spdb.jdbcdemo01;
/**
 * 读取EmployessTxt文件
 * @author 卢红全
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import log.ILog;
import log.LoggerFactory;

public class ReadEmployessTxt {
	private ILog log = LoggerFactory.getLogger(ReadEmployessTxt.class);

	private File file = null;
	private InputStream inputStream = null;
	private InputStreamReader inputStreamReader = null;
	private BufferedReader bufferedReader = null;
	private List<String> listSqList = new ArrayList<String>();
	private String string = null;
	
	/**
	 * 读取文件，将每一行文件存入到一个list集合当中
	 * @return List
	 * @throws IOException
	 */
	
	public List<String> readEmployessList() throws IOException{
		try {
			//读取文件路径
			file = new File("F:/20190811JDBC/JDBCMySQLSPDB/Resource/employees.txt");
			//创建输入流
			inputStream = new FileInputStream(file);
			//读取输入流
			inputStreamReader = new InputStreamReader(inputStream);
			//将输入流以bufferredReader封装读取
			bufferedReader = new BufferedReader(inputStreamReader);
			while((string = bufferedReader.readLine()) != null) {
				//将读取的每一行数据存入list集合中去
				listSqList.add(string);
			}
			return listSqList;
		} catch (Exception e) {
			log.error("读取文件失败！[{}]", e);
			return null;
		} finally {
			inputStream.close();
			bufferedReader.close();
		}
	}
}

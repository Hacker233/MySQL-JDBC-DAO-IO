package com.spdb.jdbcdemo01;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import log.ILog;
import log.LoggerFactory;

public class WriteSelectFile {
	private ILog log = LoggerFactory.getLogger(WriteSelectFile.class);
	
	private FileWriter fileWriter = null;
	private File file = null;
	public void writeFile(List<EmployeesVo> selectList) throws IOException {
		int size = selectList.size();
		try {
			file = new File("F:/20190811JDBC/JDBCMySQLSPDB/Resource/filtered.txt");
			fileWriter = new FileWriter(file,true);
			fileWriter.write("id-name-gender-age-degree-email-entry_date"+"\n");
			for (int i = 0; i < size; i++) {
				 fileWriter.write(selectList.get(i).getId()+"|"+selectList.get(i).getName()+"|"+selectList.get(i).getGender()+"|"+selectList.get(i).getAge()+"|"+selectList.get(i).getDegree()+"|"+selectList.get(i).getEmail()+"|"+selectList.get(i).getEntry_date()+"\n");
			}
		} catch (Exception e) {
			log.error("写入文件失败!",e);
		} finally {
			fileWriter.close();
		}
	}
}

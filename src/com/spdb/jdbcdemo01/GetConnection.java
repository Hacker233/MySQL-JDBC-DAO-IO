package com.spdb.jdbcdemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import log.ILog;
import log.LoggerFactory;


/**
 * ��װ���ݿ����ӣ�connection��prepareStalement��ResultSet�Ĺر�
 * @author ¬��ȫ
 */
public class GetConnection {
	//������־����
	private static ILog log = LoggerFactory.getLogger(GetConnection.class);
	
	//�������ݿ�����
	private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//�����������ݿ��URL
	private static final String URL = "jdbc:mysql://localhost:3306/training?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	
	//�������ݿ��û���
	private static final String USER = "root";
	
	//�������ݿ��û�����
	private static final String PASSWORD = "223399";
	
	//����һ���յ����Ӷ���
	private static Connection connection = null;
	
	/**
	 * ������̬��ע������
	 */
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			log.error("ע������ʧ��",e);
		}
	}
	
	/**
	 * ��ȡ����
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		try {
			log.info("数据库连接中....");
			connection = DriverManager.getConnection(URL, USER,PASSWORD);
			//�ж������Ƿ�ɹ�
			if(connection != null) {
				log.info("数据库连接成功...[{}]",connection.getMetaData().getDatabaseProductVersion());
				return connection;
			} else {
				throw new Exception("数据库连接失败！");
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			log.error("error",e);
			throw e;
		}
	} 
	
	/**
	 * �ر�����
	 * @param connection
	 * @return boolean
	 */
	public static boolean closeConn(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
				return true;
			} catch (SQLException e) {
				log.error("关闭连接失败！",e);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �ر�statement
	 * @param statement
	 * @return boolean
	 */
	public static boolean closeStatement(Statement statement) {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					log.error("statement关闭失败！",e);
					return false;
				}
			}
			return true;
	}
	
	/**
	 * �ر�ResultSet
	 * @param rs
	 * @return boolean
	 */
	public static boolean closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("ResultSet�ر�ʧ�ܣ�",e);
				return false;
			}
		}
		return true;
	}
}

package com.spdb.jdbcdemo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import log.ILog;
import log.LoggerFactory;

/**
 * 数据库的增删改查操作，采用DAO模式
 * @author 卢红全
 *
 */
public class EmployessDAO {
	private ILog log = LoggerFactory.getLogger(EmployessDAO.class);
	
	//声明查询存储对象
	private ResultSet rs = null;
	//声明连接对象
	private Connection connection = null;
	//声明Statement对象
	private PreparedStatement ps = null;
	/**
	 * 数据库插入
	 * @param employeesVo
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean insert(List<EmployeesVo> list) throws Exception {
		try {
			//创建数据库连接
			connection = GetConnection.getConnection();
			int listSize = list.size();
			//记录受影响的行
			int count = 0;
			//定义SQL插入语句
			String sqlString = "INSERT INTO `employees` VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sqlString);
			for (int i = 0; i < listSize; i++) {
				ps.setInt(1, list.get(i).getId());
				ps.setString(2, list.get(i).getName());
				ps.setString(3, list.get(i).getGender());
				ps.setInt(4, list.get(i).getAge());
				ps.setString(5, list.get(i).getDegree());
				ps.setString(6, list.get(i).getEmail());
				ps.setString(7, list.get(i).getEntry_date());
				
				count+=ps.executeUpdate();
			}
			
			log.info("插入[{}]行",count);
			
			return true;
		} catch (Exception e) {
			log.info("插入数据失败[{}]",e);
			try {
				connection.rollback();
			} catch (Exception e2) {
				log.error("数据库回滚异常！",e2);
			}
			return false;
		} finally {
			//关闭连接
			GetConnection.closeConn(connection);
			GetConnection.closeStatement(ps);
		}
	}
	
	/**
	 * 数据库更新操作
	 * @return
	 */
	public boolean updateEmployees(String degString) throws Exception {
		try {
			//创建数据库连接
			connection = GetConnection.getConnection();
			
			//定义更新的SQl语句
			String sqlString = "update employees set degree=? where name='Leonard' or name='Sheldon'";
			
			ps = connection.prepareStatement(sqlString);
			ps.setString(1, degString);
			//记录受影响的行
			int lenUpdate = ps.executeUpdate();
			log.info("受影响[{}]行",lenUpdate);
			
			return true;
		} catch (Exception e) {
			log.error("更新数据失败！[{}]",e);
			connection.rollback();
			return false;
		} finally {
			GetConnection.closeConn(connection);
			GetConnection.closeStatement(ps);
		}
	}
	
	public List<EmployeesVo> selectEmployees(String entry_date, String gender) {
		try {
			//创建数据库连接
			connection = GetConnection.getConnection();
			//定义查询语句
			String sqlString = "select * from employees where entry_date=? and gender=?";
			ps = connection.prepareStatement(sqlString);
			ps.setString(1, entry_date);
			ps.setString(2, gender);

			rs = ps.executeQuery();
			//声明employeesVo对象集合，将查询结果存入employ对象中去
			
			//声明list集合，存储查询结果
			List<EmployeesVo> selectList = new ArrayList<EmployeesVo>();			
			while(rs.next()) {
				EmployeesVo employeesVo = new EmployeesVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
				selectList.add(employeesVo);
			}
			
			return selectList;
		} catch (Exception e) {
			log.error("查询失败！[{}]",e);
			return null;
		} finally {
			GetConnection.closeConn(connection);
			GetConnection.closeResultSet(rs);
			GetConnection.closeStatement(ps);
		}
	}
}

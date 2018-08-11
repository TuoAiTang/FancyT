package com.py.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";//驱动名
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/bookstore"
			+ "?useUnicode=true&characterEncoding=utf8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "admin";
	private Connection conn;

	public DatabaseConnection() throws Exception {// 在构造方法中进行数据库连接
		try {
			Class.forName(DBDRIVER); // 加载数据库驱动
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);// 连接数据库
		} catch (Exception e) {
			throw e;
		}
	}
	public Connection getConnection() {//取得数据库连接
		return this.conn;
	}
	public void close() throws Exception {//数据库关闭操作
		if (this.conn != null) {		//避免空指针
			try {					
				this.conn.close();		//数据库关闭
			} catch (Exception e) {
				throw e;
			}
		}
	}
}

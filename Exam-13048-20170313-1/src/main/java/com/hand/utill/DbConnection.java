package com.hand.utill;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	private static String driver ;
	private static String url;
	private static String name;
	private static String pswd;
	
	private static final DbConnection factory = new DbConnection();
	private Connection conn;
	
	static{
		Properties prop = new Properties();
		try{
			InputStream in = DbConnection.class.getClassLoader()
					.getResourceAsStream("readme.properties");
			
			prop.load(in);
		}catch (Exception e){
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		name = prop.getProperty("name");
		pswd = prop.getProperty("pswd");
	}
	
	private DbConnection(){
		
	}
	
	public static DbConnection getInstance(){
		return factory;
	}
	
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,name,pswd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		if(conn != null) {				
			try {
				conn.close();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement ps) {
		if(ps != null) {				
			try {
				ps.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {				
			try {
				rs.close();			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.alex.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {
	
	private Connection conn=null;
	private Statement stm = null;
	private ResultSet rs= null;
	
	private InputStream input = null;
	private Properties prop = null;
	
	public DbConnection() throws ClassNotFoundException, SQLException, IOException{
		input = new FileInputStream("resources/config.file");
		prop = new Properties();
		prop.load(input);
		
		Class.forName(prop.getProperty("driver"));
		conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
		stm = conn.createStatement();
		
	}
	
	public DbConnection(String sql) throws ClassNotFoundException, SQLException, IOException {
		this();
		rs = stm.executeQuery(sql);
	}
	
	public ResultSet getResult(){
		return rs;
	}
	
	

}

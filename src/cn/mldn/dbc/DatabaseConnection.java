package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ; 
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn" ; 
	private static final String DBUSER = "scott" ; 
	private static final String PASSWORD = "tiger"  ;
	private DatabaseConnection(){} 
	public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>() ;
	public static Connection getRebuildConnection(){
		try{
			Class.forName(DBDRIVER) ; 
			return DriverManager.getConnection(DBURL,DBUSER,PASSWORD) ; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null ; 
	}
	public static Connection getConnection(){
		Connection conn = threadLocal.get() ; 
		if(conn == null){
			conn = getRebuildConnection() ;
			threadLocal.set(conn); 
		}
		return conn ; 
	}
	public static void close(){
		Connection conn = threadLocal.get() ;
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		threadLocal.remove();
	}
}

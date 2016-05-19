package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;



public class DBConn {
	private static DataSource ds = null;
	private static Connection conn = null;
	
	public static void main(String[] args) {
		Connection conn;
		DBConn dc = new DBConn();
		conn = dc.getConn_jdbc();
		try{
			Statement stmt = conn.createStatement();
			String strSql = "select * from user";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				System.out.println("name:" + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dc.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	public static Connection getConn_jdbc() {
		try{
			String url = "jdbc:mysql://localhost:3306/bbsdb";
			String username = "root";
			String password = "play";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,username, password);
			return conn;
		} catch (Exception e) {
			System.err.println("数据库连接异常：" + e.getMessage());
			return null;
		}
	}
	
	public void closeConn() {
		try {
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

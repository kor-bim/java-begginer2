package assignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtilHotelManage {
	static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("db2");
		
		try {
			Class.forName(bundle.getString("driver"));
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
		}
		
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(bundle.getString("url"), 
											   bundle.getString("user"),
											   bundle.getString("pass"));
		}catch(SQLException e) {
			System.out.println("db 연결 실패!!!");
			e.printStackTrace();
			return null;
		}
		
	}
}

package yh.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connector {
	
	public static Connection getConnection() throws Exception {

		Context initContext = new InitialContext();
		DataSource dataSource = (DataSource)initContext.lookup("java:/OracleDS");
		Connection conn = dataSource.getConnection();
		System.out.println("#### Connection Comp");
		
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			if(rs != null && !rs.isClosed()) rs.close();
			if(pstmt != null && !pstmt.isClosed()) pstmt.close();
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}

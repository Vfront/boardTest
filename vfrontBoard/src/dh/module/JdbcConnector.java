package dh.module;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class JdbcConnector {

	private Connection conn;
	
	public  Connection getConnection()
			throws SQLException{
		
		  OracleDataSource  ods = new OracleDataSource();
	        ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521/oraclejava");
	        ods.setUser("hr");
	        ods.setPassword("hr");
	        conn = ods.getConnection();
		return conn;
	}
	
}

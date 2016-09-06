package js.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import js.dao.JsDAO;
import js.dto.JsBoardDTO;

public class JsService {
	
	private JsDAO dao;
	private static DataSource ds;
	private Connection con;
	
	public JsService() {
		dao = new JsDAO();
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static{

		try {
			Context it = new InitialContext();
			ds = (DataSource)it.lookup("java:/comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<JsBoardDTO> showList() {
		
		List<JsBoardDTO> boardList = dao.showList(con);
		
		return boardList;
	}
	
	

}

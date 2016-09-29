package dh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import dh.bean.DhBoardBean;
import dh.module.JdbcConnector;

public class DhService {

	private JdbcConnector jdbcConnector;
	
	public DhService(){
		jdbcConnector = new JdbcConnector();
	}
	
	public ArrayList<DhBoardBean> summaryList(){
		ArrayList<DhBoardBean>boardList = new ArrayList<>();
	
		try {
			Connection conn = jdbcConnector.getConnection();
			String sql = "select * ";
			sql += "from t_board1 ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				DhBoardBean bean = new DhBoardBean();
				bean.setUser_id(rs.getString("user_id"));
				bean.setTitle(rs.getString("title"));
				bean.setBoard_date(rs.getString("board_date"));
				bean.setBoard_content(rs.getString("board_content"));
				bean.setBoard_id(rs.getString("board_id"));
				bean.setGroup_num(rs.getString("group_num"));
				boardList.add(bean);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		if(boardList.size()==0){
			return null;
		}else{
			return boardList;
		}
		
	}
	
	
}

package yh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import yh.connector.Connector;

public class BoardDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDAO() {
		try {
			conn=Connector.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public int select(){
		int res = 0;
		
		try{
			String sql = "select count(*) from t_board";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()){
				 res = Integer.parseInt(rs.getString("count(*)"));
		         System.out.println(Integer.parseInt(rs.getString("count(*)")));
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			Connector.closeAll(conn, pstmt, rs);
		}
		
		return res;
	}
	
	public ArrayList<BoardDTO> showList(){
		ArrayList<BoardDTO> list = new ArrayList<>();
		try{
			String sql = "select * from t_board";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()){
				 list.add(new BoardDTO(rs.getString(1), rs.getString(2)));
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			Connector.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	public int insert(BoardDTO dto) {

		int res= 0 ;

		try {
			String sql = "insert into t_board values(t_board_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connector.closeAll(conn, pstmt, rs);
		}

		return res;
	}




}

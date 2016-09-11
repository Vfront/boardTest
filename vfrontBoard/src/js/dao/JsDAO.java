package js.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import js.dto.JsBoardDTO;

public class JsDAO {

	private PreparedStatement ps;
	private ResultSet rs;
	
	
	private void closeAll(PreparedStatement ps, ResultSet rs){
		
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
			if(ps!=null && !ps.isClosed()) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<JsBoardDTO> showList(Connection con) {
		
		String sql = "select * from t_board order by num desc"; 
		List<JsBoardDTO> boardList = null;
		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()){
				if(boardList==null) boardList = new ArrayList<>();
				
				JsBoardDTO dto = new JsBoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContents(rs.getString("contents"));
				dto.setRegdate(rs.getDate("regdate"));
				
				boardList.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(ps, rs);
		}
		
		return boardList;
	}

}

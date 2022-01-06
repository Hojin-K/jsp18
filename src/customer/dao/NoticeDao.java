package customer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {
	
	public List<Notice> noticeSelAll() throws Exception{
		Connection con=DBCon.getConnection();
		
		String sql="select * from notices order by to_number(seq) desc";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		ResultSet rs=pstmt.executeQuery();
		
		List<Notice> list=new ArrayList<Notice>();
		
		while (rs.next()) {
			Notice n=new Notice(); 
			n.setSeq(rs.getString("seq")); 
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setContent(rs.getString("content"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			list.add(n);		
		}		
		return list;
	}
}

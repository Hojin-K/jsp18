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
	
	public void hitupdate(String seq) throws Exception {
		System.out.println("hit up");
		Connection con=DBCon.getConnection();

		String sql = "update notices set hit=hit+1 where seq=?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, seq);
		
		pstmt.executeUpdate();
				
	}
	
	public Notice getNotice(String seq) throws Exception { 
		String sql = "SELECT * FROM notices WHERE seq=" + seq;

		Connection con=DBCon.getConnection();		

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		rs.next();

		Notice n = new Notice();
		n.setSeq(rs.getString("seq")); 
		n.setWriter(rs.getString("writer"));
		n.setTitle(rs.getString("title"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		n.setFilesrc(rs.getString("filesrc"));

		rs.close();
		st.close();
		con.close();

		return n; 
	}
}

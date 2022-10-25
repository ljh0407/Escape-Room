package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class rbboardDao extends misroomDAO {

	private static rbboardDao rbdao = new rbboardDao();
	public static rbboardDao getInstance() {return rbdao;}
	
	
	
	
	// 10/24 이종훈 리뷰게시판 글등록
	public boolean rbwrite(String rbtitle , String rbcontent ) {
		String sql = "insert into rbboard( rbtitle , rbcontent ) values( ?, ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rbtitle); // 점수
			ps.setString(2, rbcontent); // 게시물내용 
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);}return false;
	}
	
	
	
}

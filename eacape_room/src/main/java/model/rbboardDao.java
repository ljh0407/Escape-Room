package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class rbboardDao extends misroomDAO {

	private static rbboardDao rbdao = new rbboardDao();
	public static rbboardDao getInstance() {return rbdao;}
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	// 10/24 이종훈 리뷰게시판 글등록
	public boolean rbwrite(int rbscore , String rbcontent , int mno) {
		String sql = "insert into reviewboard( rbscore , rbcontent , mno) vlaues( ? ,? ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, rbscore); // 점수
			ps.setString(2, rbcontent); // 게시물내용 
			ps.setInt(3, mno); // 게시물내용 
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);}return false;
	}
	
	
	
}

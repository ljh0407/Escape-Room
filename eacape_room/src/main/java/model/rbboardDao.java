package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	// 글 목록 출력 이종훈 10/26
	public ArrayList<rbboardDto> getrblist() {
		ArrayList<rbboardDto> list = new ArrayList<>();
		String sql = "select * from rbboard";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next() ) {
				rbboardDto dto = new rbboardDto(
						rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6), rs.getInt(7));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println(e);}return list;
		
	}
	
	
	
}

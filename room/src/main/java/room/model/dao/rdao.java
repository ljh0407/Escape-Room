package room.model.dao;

import java.util.ArrayList;

import room.model.dto.RDTO;

public class rdao extends Dao{

	private static rdao rdao = new rdao();
	public static rdao getInstance() {return rdao;}

	
	
	  // 글등록
	  public boolean setrwrite( String rtitle , String rcontent , String rfile , int mno ) {
	      String sql = "insert into rboard( rtitle , rcontent , rfile , mno ) "
	            + " values( ? , ? , ? , ? )";
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString( 1 , rtitle );
	         ps.setString( 2 , rcontent );
	         ps.setString( 3 , rfile );
	         ps.setInt(4, mno);
	         ps.executeUpdate(); return true;
	      }catch (Exception e) { System.out.println(e); } return false;
	  }
	  
	  
	  // 글 리스트
	  public ArrayList<RDTO> getrlist (RDTO dto){ // 게시물번호 , 제목 , 작성일 ,조회수 , 회원번호 = 이름
	      ArrayList<RDTO> list = new ArrayList<>();
	      String sql = "select rno,rtitle,rdate,rview,mno from rboard";

	      try {
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while( rs.next() ) {
	            RDTO dto = new RDTO(
	                rs.getInt , rs.getString()
	         }
	      }catch (Exception e) {System.out.println(e);}
	      return list;
	  }
	  
	  
	  


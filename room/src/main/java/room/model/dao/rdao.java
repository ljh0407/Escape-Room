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
	  
	  
	  // 글 리스트 모든글 출력
	  public ArrayList<RDTO> getrlist( int startrow , int listsize ,String key, String keyword ){
	      ArrayList<RDTO> list = new ArrayList<>();
	      String sql = "";
	      if(!key.equals("") && !keyword.equals("") ) { // 검색이 있을경우 / 공백이 아닐경우
	    	  sql = "select rb.* , r.mid "
	    	  		+ "	 from room r , rboard rb "
	    	  		+ "	 where r.mno = rb.mno and "+key+" like '%"+keyword+"%'"
	    	  		+ "	 order by rb.rdate desc "
	    	  		+ "	 limit "+startrow+" , "+listsize;     
	      }else { // 검색이 없을경우
	    	  sql = "select rb.* , r.mid "
	    	  		  +" from room r , rboard rb "
	    			  +" where r.mno = rb.mno "
	    			  +" order by rb.rdate desc limit "+startrow+" , "+listsize;
	      }
	    	  
	      try {
	    	  ps = con.prepareStatement(sql);
	    	  rs = ps.executeQuery();
	    			  while( rs.next() ) {
	    				  RDTO dto = new RDTO(
	    				  rs.getInt(1),    rs.getString(2),
	    				  rs.getString(3), rs.getInt(4),
	    				  rs.getString(5), rs.getString(6), 
	    				  rs.getString(7),  rs.getInt(8),
	    				  rs.getInt(9) ) ; 
	    			list.add(dto); 
	    			System.out.println("다오 : "+list);
	    			  }
	    		 return list; 
	      }catch (Exception e) {System.out.println(e);
	      return null; 
	      }
	     

	  }
	  
	  // 게시글 상세보기
	  public RDTO getrview(int rno) {
		  String sql = "select rb.* , r.mid from room r , rboard rb where r.mno = rb.mno and rb.rno = "+rno;
		  System.out.println("sql : "+sql);
		  System.out.println("rno : "+rno);
		  try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) {
				RDTO dto = new RDTO(
						rs.getInt(1),    rs.getString(2),
	    				rs.getString(3), rs.getInt(4),
	    				rs.getString(5), rs.getString(6), 
	    				rs.getString(7), rs.getInt(8),
	    				rs.getInt(9) ) ; 
					return dto; 
			}
		} catch (Exception e) {System.out.println(e);}
		    return null; 
	  }
	  
	  
	  // 게시글 수정
	  public boolean rupdate( int rno , String rtitle ,
			  String rcontent , String rfile) {
		  String sql = "update rboard set rtitle = ? , rcontent=? , rfile = ? where rno = ? " ;
		  try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rtitle);
			ps.setString(2, rcontent);
			ps.setString(3, rfile);
			ps.setInt(4, rno);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);} return false;
	  }
	  
	  // 댓글작성 
	  public boolean rewrite(String rcomment , int rno ) {
		 String sql = "update rboard set rcomment = ? where rno = ? ";
		  try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rcomment);
			ps.setInt(2, rno );
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);} return false;
	  }
	  
	  
	  // 전체 게시물 수 (페이징처리)
	  public int gettotalsize( String key , String keyword ) {
		  String sql = "";
		  // 검색이 있을경우
		  if( !key.equals("") && !keyword.equals("") ) {
			  // 검색을 했을경우 찾고싶은 리스트만 출력
			  sql = " select count(*) from room r , rboard rb where r.mno = rb.mno and "+key+" like '%"+keyword+"%'";
		  }else { // 검색을 안했을경우 리스트 출력
			sql = " select count(*) from room r , rboard rb where r.mno = rb.mno";
		  }
		  try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next() ) return rs.getInt(1);
		} catch (Exception e) {System.out.println(e);}
		  return 0;
	  }
	  
}
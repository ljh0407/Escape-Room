package room.model.dao;

public class rdao extends Dao{

	private static rdao rdao = new rdao();
	public static rdao getInstance() {return rdao;}

	
	
	
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

}

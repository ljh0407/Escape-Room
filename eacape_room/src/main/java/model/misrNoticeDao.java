package model;

public class misrNoticeDao extends misroomDAO{

	
	private static misrNoticeDao mdao = new misrNoticeDao();
	public static misrNoticeDao getInstance() {return mdao;}
	
	// 1. 공지사항 글쓰기
	public boolean mwrite(String ntitle , String ncontent) {
		String sql = "insert into notice(ntitle,"
				+ " ncontent)values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ntitle);
			ps.setString(2, ncontent);
			ps.executeUpdate(); 
			System.out.println(ncontent);
			System.out.println(ntitle);
			return true;
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2. 공지사항 글출력
	
	
}

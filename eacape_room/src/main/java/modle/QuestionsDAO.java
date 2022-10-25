package modle;

public class QuestionsDAO extends misroomDAO{
	private static QuestionsDAO hdao = new QuestionsDAO();
	public static QuestionsDAO getIncetance() {return hdao;}
	
	//1.글쓰기 고은시[10/24]
	public boolean write(String btitle , String bcontent , int mno) {
		System.out.println(btitle);
		System.out.println(bcontent);
		System.out.println(mno);
		String sql = " insert into Questions (btitle,bcontent,mno) values(?,?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, mno);
			ps.executeUpdate();
			System.out.println("db성공");
			return true;
		} catch (Exception e) {System.out.println("글등록"+e);}
			return false;
	}
}

package model;

import java.util.ArrayList;

import model.misroomDAO;

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
	//2.문의사항list 고은시 [10/25]
	public ArrayList<boardDTO> getlist(){
		ArrayList<boardDTO> list = new ArrayList<>();
		String sql = " select * from Questions ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				boardDTO dto = new boardDTO(
						rs.getInt(1), rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6));
				list.add(dto);
				System.out.println(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("출력오류"+e);}
			return null;
	}

	
}

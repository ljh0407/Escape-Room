package model;

import java.util.ArrayList;

import model.misroomDAO;

@SuppressWarnings("unused")
public class QuestionsDAO extends misroomDAO{
	private static QuestionsDAO hdao = new QuestionsDAO();
	public static QuestionsDAO getIncetance() {return hdao;}
	
	//1.글쓰기 고은시[10/26] 글 등록파일추가 다오수정
	public boolean write(String btitle , String bcontent ,String  bfile , int mno) {
		String sql = "insert into Questions (btitle,bcontent,bfile,mno) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setInt(4, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("글등록"+e);}
		return false;
	}
	//2.문의사항list 고은시 [10/26] 완료
	public ArrayList<boardDTO> getlist(){
		ArrayList<boardDTO> list = new ArrayList<>();
		String sql ="select * from Questions";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				boardDTO dto = new boardDTO(
						rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("출력오류"+e);}
			return null;
	}

	
}

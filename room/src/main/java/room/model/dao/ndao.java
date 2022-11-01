package room.model.dao;

import java.util.ArrayList;

import javax.swing.text.html.parser.DTD;

import room.model.dto.NDTO;



public class ndao extends Dao{

	private static ndao ndao = new ndao();
	public static ndao getInstance() {return ndao;}
	
	
	// 글 입력
	public boolean nwirte(String ntitle , String ncontent  , int mno) {
	String sql = "insert into notice( ntitle , ncontent ,  mno) values(?,?,?)";
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1, ntitle);
		ps.setString(2, ncontent);
		ps.setInt(3, mno);
		ps.executeUpdate(); 
		return true;
	} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	//글 출력
	public ArrayList<NDTO> getlist(){
		ArrayList<NDTO> list = new ArrayList<>();
		String sql = "select notice.* , room.mid from notice , room where notice.mno = room.mno";
		try {
			ps= con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
			NDTO dto = new NDTO(
					rs.getInt(1), rs.getString(2),
					rs.getString(3) , rs.getString(4),
					rs.getInt(5),rs.getInt(6),
					rs.getString(7));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("출력되나"+e);}
		return null;
	}
	
	//3. 상세페이지 11/01 주혁
	public NDTO getboard(int nno) {
		String sql ="select n.* , r.mid from room r , notice n where r.mno = n.mno and nno = "+nno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				NDTO dto = new NDTO(
				rs.getInt(1), rs.getString(2),
				rs.getString(3) , rs.getString(4),
				rs.getInt(5),rs.getInt(6),
				rs.getString(7));
				System.out.println("연결"+dto);
				return dto;
			}
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	//4. 글삭제
	
	public boolean delete(int nno) {
		String sql = "delete from notice"
				+ " where nno="+nno;
		try {
			ps= con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 첨부파일이 없음
	
	//5. 게시물 수정
	public boolean nupdate( int nno , String ntitle , String )
	
	
	
	
	}

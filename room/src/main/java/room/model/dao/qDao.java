package room.model.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import room.model.dto.QDTO;

public class qDao extends Dao{
	private static qDao qdao = new qDao();
	public static qDao getIncetance() {return qdao;}
	
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
	//2.문의사항list 고은시 [11/04] 페이징 추가(고은시 11/08 sql문 수정)
	public ArrayList<QDTO> getlist(int startrow , int listsize){
		System.out.println( startrow );
		System.out.println( listsize);
		
		ArrayList<QDTO> list = new ArrayList<>();
		String sql = "select Questions.* , room.mid from Questions , room where Questions.mno = room.mno order by Questions.bdate desc limit "+startrow+" , "+listsize;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { 
				QDTO qdto = new QDTO(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						0, rs.getInt(7), rs.getString(8));
				list.add(qdto);
			}
		}catch (Exception e) {System.out.println(e);}
		System.out.println( list.toString() );
		return list;
	}
	//3.고은시[10/28] 개별글조회(11/01 dto수정해서 필드 수정)
	public QDTO getqboard(int bno) {
		String sql = "select q.* , r.mid from room r , Questions q where r.mno = q.mno and q.bno =" +bno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				QDTO qdto = new QDTO(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						0, rs.getInt(7), rs.getString(8));
				return qdto;
			}
		} catch (Exception e) {System.out.println("글조회"+e);}
		return null;
	}
	//4.글삭제[10/31]고은시
	public boolean qdelete(int bno) {
		String sql = " delete from Questions where bno = "+bno;
		System.out.println("다오"+sql);
		System.out.println("다오"+bno);
		try {
			ps = con.prepareStatement(sql);
			//삭제된 레코드수가 1개이상일때
			int count = ps.executeUpdate();
			if(count == 1)
			return true;
		} catch (Exception e) {System.out.println("삭제오류"+e);}
			return false;
	}
	//6.첨부파일 삭제[11/07 고은시]
	public boolean bfiledelete(int bno) {
		String sql = " update Questions set bfile = null where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("첨부파일 수정오류"+e);}
			return false;
	}
	//7.게시물 수정[고은시 11/07]
	public boolean qupdate( int bno , String btitle , String bcontent , String bfile ) {
		String sql = " update Questions set btitle = ? , bcontent=? , bfile = ?  where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setInt(4, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("게시물 수정오류"+e);}
			return false;
	}
	//5.페이지처리  [고은시 11/04]
	public int gettotalsize() {
		String sql = " select count(*) from Questions ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
		} catch (Exception e) {System.out.println("페이징 오류"+e);}
			return 0;
	}
	//8.관리자 댓글달기 [고은시 11/10]
	public boolean rwrite( String reply , int bno) {
		String sql = " update Questions set reply = ? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , reply ); 
			ps.setInt( 2 , bno );
			ps.executeUpdate(); 
			return true;
		} catch (Exception e) {System.out.println("관리자 댓글오류"+e);}
			return false;
	}
	
}

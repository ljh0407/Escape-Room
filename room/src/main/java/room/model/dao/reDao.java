package room.model.dao;

import java.util.ArrayList;

import room.model.dto.reDto;

public class reDao extends Dao {

	private static reDao redao = new reDao();
	public static reDao getIncetance() {return redao;}
	
	
	
	
	//예약 입력
	
	public boolean rewirte(String gname , String gdate , int mno) {
		String sql = "insert into reservation( gname , gdate ,mno) values (?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, gname);
			ps.setString(2, gdate);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("연결안대네"+e);}
		return false;
	}

	
	
	//예약 관리자 페이지 출력
	public ArrayList<reDto> reservationlist(){
		ArrayList<reDto> list = new ArrayList<>();
		String sql=" select reservation.*, room.mid from reservation , room where reservation.mno = room.mno";
		try {
			ps=con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				reDto dto = new reDto(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getInt(4),rs.getString(5));
				list.add(dto);
			}
			return list;
		}catch (Exception e) {System.out.println(e);}
		return list;
	
	
	}
}

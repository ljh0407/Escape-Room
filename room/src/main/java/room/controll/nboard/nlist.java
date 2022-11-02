package room.controll.nboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import room.model.dao.ndao;
import room.model.dto.NDTO;


@WebServlet("/nlist")
public class nlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public nlist() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주혁 
		//1.요청 이 요청은 페이징처리 요청입니다
		
		int listsize= Integer.parseInt( request.getParameter("listsize"));		
		//System.out.println(listsize); 3으로설정했었는데 3나오니 검색종료 확인용		
		//2. 전체게시물수
		int totalsize = ndao.getInstance().gettotalsize();
		//3.전체 페이지수 계산
		int totalpage = 0;
		if( totalsize % listsize == 0) totalpage = totalsize /listsize; // 나머지가없으면
		else totalpage = totalsize / listsize +1; // 나머지가 존재하면 나머지를 표시할페이지
		//페이징처리 jsonobject
		JSONObject boards = new JSONObject();
		
		// 형변환
		ArrayList<NDTO> list = new ndao().getInstance().getlist();
		JSONArray array = new JSONArray();
		for(int i = 0; i< list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("nno",list.get(i).getNno() );
			object.put("ntitle",list.get(i).getNtitle() );
			object.put("ncontent",list.get(i).getNcontent() );
			object.put("ndate",list.get(i).getNdate() );
			object.put("nview",list.get(i).getNview() );
			object.put("mno",list.get(i).getMno() );
			object.put("mid",list.get(i).getMid() );
			array.add(object);
			
		}
		System.out.println( array.toString() );
		//4.페이징
		boards.put("totalpage", totalpage);
		boards.put("data",array);
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
		
		
	
		
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

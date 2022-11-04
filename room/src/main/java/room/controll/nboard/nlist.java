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
		
		// 11.04 검색처리 주혁
		request.setCharacterEncoding("UTF-8");
		String key	=request.getParameter("key");
		String keyword = request.getParameter("keyword");
		
		
		
		
		
		//주혁 
		//1.요청 이 요청은 페이징처리 요청입니다
		
		// 1.페이지 당 게시물 수
		int listsize= Integer.parseInt( request.getParameter("listsize"));		
		//System.out.println(listsize); 3으로설정했었는데 3나오니 검색종료 확인용		
		
		//2. 전체게시물수	2-1 검색된 게시물수				2-1key , keyword 넘겨줌
		int totalsize = ndao.getInstance().gettotalsize(key,keyword);
		System.out.println(totalsize);
		//3.전체 페이지수 계산
		int totalpage = 0;
		if( totalsize % listsize == 0) totalpage = totalsize /listsize; // 나머지가없으면
		else totalpage = totalsize / listsize +1; // 나머지가 존재하면 나머지를 표시할페이지
		
		//3. 현재페이지 임의로 하나만듬 
		//int page = 1;
		//3-1 이젠 페이지당 으로해야하니 불러옴 page
		int page = Integer.parseInt( request.getParameter("page"));
		
		// 3. 시작 게시물 행번호
		int startrow =  (page-1)*listsize;
		
		//3-3 화면에 표시할 최대 버튼수
		int btnsize = 5; //버튼 5개씩 표시(생성)
			// 버튼 시작번호 starbtn
		int starbtn = ( (page-1)/btnsize) * btnsize +1; 
			//버튼 끝번호 endbtn
		int endbtn= starbtn +4; 
			
			if(endbtn >totalpage) endbtn = totalpage;
		
		//페이징처리 jsonobject
		JSONObject boards = new JSONObject();
		
		// 형변환
		ArrayList<NDTO> list =  ndao.getInstance().getlist(startrow,listsize);
		JSONArray array = new JSONArray();
		for(int i = 0; i<list.size(); i++) {
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
		//System.out.println( array.toString() );
		//4.페이징
		boards.put("totalpage", totalpage);
		boards.put("data", array);
		boards.put("starbtn",starbtn);
		boards.put("endbtn", endbtn);
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
		
		
	
		
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

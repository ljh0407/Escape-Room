package room.controll.rboard;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import room.model.dao.rdao;
import room.model.dao.userDao;
import room.model.dto.RDTO;

/**
 * Servlet implementation class 
 */
@WebServlet("/rboard/rwrite")
public class rwrite extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // * 첨부파일 일 경우 [ 일반 request 요청 불가능 ] 
		MultipartRequest multi = new MultipartRequest(
	            request, 
	            request.getSession().getServletContext().getRealPath("/rboard/rupload"), 
	            1024*1024*10,
	            "UTF-8",
	            new DefaultFileRenamePolicy() ); // 첨부파일명이 동일할경우 자동으로 새로운이름 부여
		
		String rtitle = multi.getParameter("rtitle"); 
		String rcontent = multi.getParameter("rcontent"); 
		String rfile = multi.getParameter("rfile"); 	
		//로그인 성공한 아이디 [세션] 호출
		//String mid = (String)request.getAttribute("mid"); 
		// 일단 세션 호출 하실때
		String mid = (String)request.getSession().getAttribute("mid"); 
		
		int mno = userDao.getInstance().getMno(mid); 
		
		boolean result = rdao.getInstance().setrwrite(rtitle, rcontent, rfile , mno);
		
		response.getWriter().print(result);
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글리스트 출력 모든글
		// 페이징처리
		
				request.setCharacterEncoding("UTF-8"); // 한글인코딩
				
				// 검색처리
				String key = request.getParameter("key");
				String keyword = request.getParameter("keyword");
				
				
				// 페이지당 게시물수
				int listsize = Integer.parseInt(request.getParameter("listsize") );
				
				// 2. 전체페이지수
				int totalsize = rdao.getInstance().gettotalsize(key, keyword);
				
				// 3. 전체 페이지수 계산
				int totalpage = 0;	
				//  전체페이지수 / 페이지당 게시물수가 나머지가 0이면   
				if(totalsize % listsize == 0) { totalpage = totalsize / listsize; // 나머지가 없으면
				}else {totalpage = totalsize / listsize + 1 ;} // 나머지가 존재하면 페이지 1개 추가 
				
				// 현재 페이지수
				int page = Integer.parseInt(request.getParameter("page"));
				// 페이지별 시작 게시물 행번호
				int startrow = (page-1)*listsize;
				// 화면에 표시할 최대 버튼수
				int btnsize = 5; // 버튼 5개씩 표시 [ 5배수 ]
					// 버튼 시작번호
				int startbtn = ( (page-1) / btnsize ) * btnsize +1 ; // ( (현재페이지수-1) / 최대 버튼수 ) * 최대버튼수 +1    
					// 버튼 끝번호
				int endbtn = startbtn + (btnsize-1);
				// 만약 버튼 끝번호가 전체페이지보다 크면 마지막번호는 마지막페이지 번호
					if(endbtn > totalpage ) endbtn = totalpage;
					
				// 페이징에 필요한 정보를 담는 객체생성
					JSONObject rboards = new JSONObject();
		
		ArrayList<RDTO> list = new rdao().getInstance().getrlist(startrow , listsize , key , keyword);	
		// 변환
		JSONArray array = new JSONArray();
		for( int i = 0 ; i<list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("rno", list.get(i).getRno());
			object.put("rtitle", list.get(i).getRtitle());
			object.put("rcontent", list.get(i).getRcontent());
			object.put("rscore", list.get(i).getRscore());
			object.put("rfile", list.get(i).getRfile());
			object.put("rcomment", list.get(i).getRcomment());
			object.put("rdate", list.get(i).getRdate());
			object.put("rview", list.get(i).getRview());
			object.put("mno", list.get(i).getMno());
			array.add(object);
		}
		
		rboards.put("totalpage", totalpage);	// 1. 전체페이지수
		rboards.put("data", array);				// 2. 게시물 리스트
		rboards.put("startbtn", startbtn);		// 3. 버튼의 시작번호
		rboards.put("endbtn", endbtn);			// 4. 버튼의 끝번호
		rboards.put("totalsize", totalsize);	// 5. 전체 게시물 수
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(rboards); System.out.println("서블릿"+rboards);
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}

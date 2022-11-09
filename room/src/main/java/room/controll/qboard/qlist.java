package room.controll.qboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import room.model.dao.qDao;
import room.model.dto.QDTO;

/**
 * Servlet implementation class qlist
 */
@WebServlet("/qlist")
public class qlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징처리[고은시 11/04]
		request.setCharacterEncoding("UTF-8");
		//요청
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		//전체페이지
		int totalsize = qDao.getIncetance().gettotalsize();
		
		int totalpage = 0;
		if(totalsize % listsize == 0) {totalpage = totalsize / listsize;}
		else {totalpage = totalsize / listsize+1;}
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		//페이지 시작 게시물번호
		int startrow = (page-1)*listsize;
		
		//화면에 표시할 최대버튼 5칸
		int btnsize = 5; 
		//버튼 시작
		int startbtn = ((page-1)/btnsize)*btnsize+1;
		
		//버튼 끝
		int endbtn = startbtn+(btnsize-1);
		if(endbtn > totalpage) {endbtn = totalpage;}
		
		//페이징처리에 필요한 정보담기
		JSONObject boards = new JSONObject();
		
		ArrayList<QDTO> list = qDao.getIncetance().getlist(startrow,listsize);
		JSONArray array = new JSONArray();
		for( int i = 0 ;i<list.size() ; i++ ) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno() );
			object.put("btitle", list.get(i).getBtitle() );
			object.put("bcontent", list.get(i).getBcontent() );
			object.put("bfile", list.get(i).getBfile() );
			object.put("bdate", list.get(i).getBdate() );
			object.put("reply", list.get(i).getReply() );
			object.put("bview", list.get(i).getBview() );
			object.put("mno", list.get(i).getMno() );
			object.put("mid", list.get(i).getMid() );
			array.add(object);
		}
		boards.put("totalpage", totalpage);	//전체 페이지
		boards.put("data", array);			//게시물 리스트
		boards.put("startbtn", startbtn);	//버튼의 시작번호
		boards.put("endbtn", endbtn);		//버튼의 끝 번호
		boards.put("totalsize", totalsize);	//게시물 수
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

package room.controll.qboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import room.model.dao.qDao;
import room.model.dto.QDTO;

/**
 * Servlet implementation class qview
 */
@WebServlet("/qview")
public class qview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("통신");
		//고은시 [10/27] 개별 글 조회
		//선택한 게시물 번호 요청
		int bno = (Integer)request.getSession().getAttribute("bno");
		System.out.println("요청"+bno);
		//다오처리
		QDTO qdto = qDao.getIncetance().getboard(bno);
		//개별글 확인
		JSONObject object = new JSONObject();
			object.put("bno",qdto.getBno());
			object.put("btitle",qdto.getBtitle());
			object.put("bcontent",qdto.getBcontent());
			object.put("bfile",qdto.getBfile());
			object.put("bdate",qdto.getBdate());
			object.put("reply",qdto.getReply());
			object.put("bview",qdto.getBview());
			object.put("mno",qdto.getMno());
		
		response.getWriter().print(object);
		System.out.println("서블릿"+object);
		//삭제
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package room.controll.rboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import room.model.dao.rdao;
import room.model.dto.RDTO;

/**
 * Servlet implementation class rview
 */
@WebServlet("/rboard/rview")
public class rview extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 요청
	int rno = (Integer)request.getSession().getAttribute("rno");
	// db 처리
	RDTO dto = 
			rdao.getInstance().getrview(rno);
	// dto ---> JSON 형변환
	JSONObject object = new JSONObject();
	object.put("rno", dto.getRno());
	object.put("rtitle", dto.getRtitle());
	object.put("rcontent", dto.getRcontent());
	object.put("rscore", dto.getRscore());
	object.put("rfile", dto.getRfile());
	object.put("rcomment", dto.getRcomment());
	object.put("rdate", dto.getRdate());
	object.put("rview", dto.getRview());
	object.put("mno", dto.getMno());
	// 로그인한 세션 정보 호출
	String mid = (String)request.getSession().getAttribute("mid");
	// 로그인한 세션과 현재 게시물의 작성자와 일치하면
	if(mid != null && mid.equals(dto.getMno() )) {
		// 로그인 했으면서 로그인아이디와 현재게시물의 작성자 아이디가 동일하면
		object.put("btnaction", true);
	}

	// 응답
	response.setCharacterEncoding("UTF-8");
	response.getWriter().print(object);
	}
	
	private static final long serialVersionUID = 1L;
       
    public rview() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 세션 생성
		int rno = Integer.parseInt( request.getParameter("rno") );
	
		request.getSession().setAttribute("rno", rno);
	
	}

}

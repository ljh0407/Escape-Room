package room.controll.nboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import room.model.dao.ndao;

/**
 * Servlet implementation class nviewload
 */
@WebServlet("/nviewload")
public class nviewload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nviewload() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청
		//int nno = Integer.parseInt(request.getParameter("nno"));
		
		
		
		
		
	/*	HttpSession session = request.getSession();
		// 세션 저장 
		session.setAttribute("nno",nno);
		//로그인한 회원아이디
		String mid = (String)session.getAttribute("mid");
		if( session.getAttribute(nno+mid)==null) {
			// 3. DAO 조회수 증가
			ndao.getInstance().nviewupdate(nno);			
			
			request.getSession().setAttribute(nno+mid,true);
			request.getSession().setMaxInactiveInterval(60*60*24); //하루
		}
	
	11.01 나중에 다시 작성하자 혁아
	*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

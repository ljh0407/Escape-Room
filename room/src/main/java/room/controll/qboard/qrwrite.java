package room.controll.qboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.qDao;
import room.model.dao.userDao;

/**
 * Servlet implementation class qrwrite
 */
@WebServlet("/qrwrite")
public class qrwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qrwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	////////고은시[11/09]관리자 댓글////////////////////////////////////////////////////////////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String reply = request.getParameter("reply");
		
		String mid = (String)request.getSession().getAttribute("mid"); 
	    int mno = userDao.getInstance().getMno(mid);
	    //비로그인일 경우 반환
	    if( mno == 0) { response.getWriter().print(0); return; }
	    
	    int bno = (Integer)request.getSession().getAttribute("bno");
	    
	    boolean result = false;
		//디비처리
		if(type.equals("reply")) {result = qDao.getIncetance().rwrite(reply , mno , bno);}
		//결과
		if(result) {response.getWriter().print("1");}
		else {response.getWriter().print("2");} // db오류
	}

}

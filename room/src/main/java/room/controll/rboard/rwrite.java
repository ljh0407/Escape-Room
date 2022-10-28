package room.controll.rboard;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import room.model.dao.rdao;
import room.model.dao.userDao;

/**
 * Servlet implementation class dfsf
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
		
		String rtitle = multi.getParameter("rtitle"); System.out.println("제목 : "+rtitle);
		String rcontent = multi.getParameter("rcontent"); System.out.println("내용 : "+ rcontent);
		String rfile = multi.getParameter("rfile"); 	System.out.println("첨부파일 : "+rfile);
		//로그인 성공한 아이디 [세션] 호출
		//String mid = (String)request.getAttribute("mid"); // 아 여기가.... 세션이 아니였네요...
		// 일단 세션 호출 하실때
		String mid = (String)request.getSession().getAttribute("mid"); 
		
		int mno = userDao.getInstance().getMno(mid); 
		System.out.println("id"+mid);
		System.out.println("넘버"+mno);
		
		boolean result = rdao.getInstance().setrwrite(rtitle, rcontent, rfile , mno);
		
		response.getWriter().print(result);
		System.out.println("dao"+result);
	
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}

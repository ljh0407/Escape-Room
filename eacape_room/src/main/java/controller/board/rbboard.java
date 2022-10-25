package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.rbboardDao;

/**
 * Servlet implementation class rbboard
 */
@WebServlet("/board/rbboard")
public class rbboard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// 요청
	request.setCharacterEncoding("UTF-8"); // 한글요청
	String rbtitle = request.getParameter("rbtitle") ; 
	System.out.println(rbtitle);
	String rbcontent = request.getParameter("rbcontent");		System.out.println(rbcontent);
	
	// dao 처리
	boolean result = rbboardDao.getInstance().rbwrite( rbtitle , rbcontent );
	System.out.println(result);
	
	// 응답
	response.getWriter().print(result);
	
	}
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rbboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

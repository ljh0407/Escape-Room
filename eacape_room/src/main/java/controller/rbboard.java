package controller;

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
@WebServlet("/rbboard")
public class rbboard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// 요청
	request.setCharacterEncoding("UTF-8");
	int rbno = Integer.parseInt(request.getParameter("rbno") );
	String rbcontent = request.getParameter("rbcontent");
	int mno = Integer.parseInt(request.getParameter("mno"));
	
	// dao 처리
	
	
	boolean result = rbboardDao.getInstance().rbwrite()
	
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

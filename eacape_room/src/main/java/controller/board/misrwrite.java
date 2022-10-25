package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QuestionsDAO;
import model.misroomDao2;


@WebServlet("/board/misrwrite")
public class misrwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public misrwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고은시[10/24]
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		// 회원번호
		int mno = misroomDao2.getInstance().getMno( (String) request.getSession().getAttribute("mid"));
		System.out.println("*:"+mno);
		// db처리
		boolean result = QuestionsDAO.getIncetance().write(btitle, bcontent, mno);
		//응답
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

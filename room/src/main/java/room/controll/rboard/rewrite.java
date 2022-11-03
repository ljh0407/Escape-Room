package room.controll.rboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.rdao;
import room.model.dao.userDao;
import room.model.dto.RDTO;

/**
 * Servlet implementation class rewrite
 */
@WebServlet("/rboard/rewrite")
public class rewrite extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 요청
		int rno = (Integer)request.getSession().getAttribute("rno");
		String rcomment = request.getParameter("rcomment");
		
		
		
		// 처리
		boolean result = rdao.getInstance().rewrite(rcomment ,rno);
		
		// 결과 반환
		response.getWriter().print(result);
		response.setCharacterEncoding("UTF-8");
		
		
		
		
		
	}
	private static final long serialVersionUID = 1L;
    public rewrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}


}

package room.controll.nboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.ndao;
import room.model.dto.NDTO;

/**
 * Servlet implementation class ndelete
 */
@WebServlet("/ndelete")
public class ndelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ndelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.삭제할 번호 요청
		int nno = Integer.parseInt( request.getParameter("nno"));
		request.getSession().setAttribute("nno",nno);
		NDTO dto=ndao.getInstance().getboard(nno); // 게시물 정보가져온다
		
		
		
		//2. dao 처리 db 내 데이터 삭제
		boolean result = ndao.getInstance().delete(nno);
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

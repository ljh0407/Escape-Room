package room.controll.qboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.qDao;

@WebServlet("/qputdelete")
public class qputdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public qputdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	//////고은시[10/31]  삭제미완//////////
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		//dao
		boolean result = new qDao().qdelete(bno);
		//응답
		response.getWriter().print(result);
		System.out.println(result);
	}

}

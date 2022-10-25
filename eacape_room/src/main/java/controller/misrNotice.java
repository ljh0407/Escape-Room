package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.misrNoticeDao;
import model.misrNoticeDto;
import model.misroomDAO;
import model.misroomDao2;




@WebServlet("/misrNotice")
public class misrNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public misrNotice() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String ntitle =	request.getParameter("ntitle");	System.out.println(ntitle);
		String ncontent = request.getParameter("ncontent"); System.out.println(ncontent);
		
		int mno = misroomDao2.getInstance().getMno( (String) request.getSession().getAttribute("mid"));
		System.out.println(mno);
		/*
		 * misrNoticeDto misrDto = new misrNoticeDto(0, ntitle, ncontent, ntitle, 0, 0,
		 * ); misrNoticeDao misrNoticeDao = new misrNoticeDao();
		 */
		
		
		boolean result = misrNoticeDao.getInstance().mwrite(ntitle, ncontent);
		System.out.println(result);
		response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			

		
		
	}

}

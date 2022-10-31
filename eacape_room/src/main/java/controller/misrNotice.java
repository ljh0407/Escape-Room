package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.misrNoticeDto;
import model.misroomDao2;


@WebServlet("/misrNotice")
public class misrNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public misrNotice() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
	request.setCharacterEncoding("UTF-8");
	String ntitle =	request.getParameter("ntitle");	System.out.println(ntitle);
	String ncontent = request.getParameter("ncontent"); System.out.println(ncontent);
	
	misrNoticeDto misrDto = new misrNoticeDto(0, ntitle, ncontent, null, 0);
	
	misroomDao2 misroomDao2 = new misroomDao2();
	boolean result = misroomDao2.mwrite(misrDto);
	response.getWriter().print(result);
	
		
		
	}

}

package room.controll.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.userDao;
import room.model.dto.USERDTO;

@WebServlet("/usersingup")
public class usersingup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public usersingup() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///회원가입
		request.setCharacterEncoding("UTF-8");
		
		//입력받은 데이터
		String mname = request.getParameter("mname");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mphone = request.getParameter("mphone");
				
		//DTO객체화
		USERDTO dto = new USERDTO(0, mname, mid, mpw, mphone);
				
		//결과제어
		boolean result = userDao.getInstance().signup(dto);
		System.out.println(result);	
		if(result) {response.sendRedirect("/jspweb/member/login.jsp");}
	    else {System.out.println("/jspweb/member/signup.jsp");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

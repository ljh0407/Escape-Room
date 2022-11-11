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
		//요청
	      request.setCharacterEncoding("UTF-8");
	      String type = request.getParameter("type");
	      String rcomment = request.getParameter("rcomment");
	      System.out.println("요청1"+type);
	      System.out.println("요청2"+rcomment);
	      
	      String mid = (String)request.getSession().getAttribute("mid"); 
	       int mno = userDao.getInstance().getMno(mid);
	       //비로그인일 경우 반환
	       if( mno == 0) { response.getWriter().print(0); return; }
	       
	       int rno = (Integer)request.getSession().getAttribute("rno");
	       System.out.println("번호"+rno);
	       
	       boolean result = false;
	      //디비처리
	      if(type.equals("rcomment")) {result = rdao.getInstance().rewrite(rcomment , rno);}
	      //결과
	      if(result) {response.getWriter().print("1");}
	      else {response.getWriter().print("2");} // db오류
	      System.out.println("서블릿"+result);
		
		
		
	}
	private static final long serialVersionUID = 1L;
    public rewrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}


}

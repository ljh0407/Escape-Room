package room.controll.nboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import room.model.dao.ndao;
import room.model.dao.userDao;


@WebServlet("/nwrite")
public class nwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public nwrite() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("asdadsds");
		//글쓰기 10-27 주혁

				
	
		String ntitle =	request.getParameter("ntitle");		
		String ncontent =request.getParameter("ncontent");
		
		
		int mno = userDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		boolean result = 
			ndao.getInstance().nwirte(ntitle, ncontent, mno);
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	
	
	}

}

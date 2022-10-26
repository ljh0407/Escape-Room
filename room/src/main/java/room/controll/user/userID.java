package room.controll.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.userDao;

@WebServlet("/userID")
public class userID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userID() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("UTF-8");
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
				
		String result = userDao.getInstance().findID(mname, mphone);
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

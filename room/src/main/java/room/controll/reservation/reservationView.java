package room.controll.reservation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.conf.IntegerProperty;

import room.model.dao.reDao;
import room.model.dao.userDao;


@WebServlet("/reservationView")
public class reservationView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public reservationView() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gname = request.getParameter("gname");
		String gdate = request.getParameter("gdate");
	
		int mno = userDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		boolean result=
				reDao.getIncetance().rewirte(gname,gdate,mno);
		
		//응답
		response.setCharacterEncoding("UTF-8");
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

package room.controll.nboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.ndao;
import room.model.dto.NDTO;


@WebServlet("/nupdate")
public class nupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public nupdate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//요청
	String ntitle = request.getParameter("ntitle");
	String ncontent = request.getParameter("ncontent");
	
	int nno = (Integer)request.getSession().getAttribute("nno");
	

	//4. dao 처리
	boolean result=	ndao.getInstance().nupdate(nno,ntitle,ncontent);
	
	//결과반환
	
	response.getWriter().print(result);
	
	}

}

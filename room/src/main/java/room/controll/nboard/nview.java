package room.controll.nboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import room.model.dao.ndao;
import room.model.dto.NDTO;


@WebServlet("/nview")
public class nview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public nview() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int nno =(Integer)request.getSession().getAttribute("nno"); // 세션 호출 
		//int nno = Integer.parseInt(request.getParameter("nno"));
		NDTO dto = 
		ndao.getInstance().getboard(nno);
		
		JSONObject object = new JSONObject();
		object.put("nno",dto.getNno());
		object.put("ntitle",dto.getNtitle());
		object.put("ncontent",dto.getNcontent());
		object.put("ndate",dto.getNdate());
		object.put("nview",dto.getNview());
		object.put("mno",dto.getNno());
		object.put("mid",dto.getMid());
			
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
		System.out.println("서브렛"+object);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		request.getSession().setAttribute("nno" , nno);	// 세션 저장 
		
	}

}

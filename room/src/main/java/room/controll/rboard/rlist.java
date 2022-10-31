package room.controll.rboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import room.model.dao.rdao;
import room.model.dto.RDTO;

/**
 * Servlet implementation class rlist
 */
@WebServlet("/rboard/rlist")
public class rlist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		int rno = (Integer)request.getSession().getAttribute("rno");
		
		// dao처리
		RDTO dto = 
				rdao.getInstance().getrlist();
		
		ArrayList<rdao>
		// dto --> JSON형변환
		JSONObject object = new JSONObject();
		object.put("rno", dto.getRno());
		object.put("rtitle", dto.getRtitle());
		object.put("rdate", dto.getRdate());
		object.put("rview", dto.getRview());
		object.put("mno", dto.getMno());
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package room.controll.reservation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import room.model.dao.reDao;
import room.model.dao.userDao;
import room.model.dto.reDto;

/**
 * Servlet implementation class reservationlist
 */
@WebServlet("/reservationlist")
public class reservationlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public reservationlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     int mno = userDao.getInstance().getMno((String) request.getSession().getAttribute("mid"));
		
			//2. db요청
		ArrayList<reDto> list = reDao.getIncetance().reservationlist();
		//형변환
		JSONArray array = new JSONArray();
		for( int i=0; i<list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("gno", list.get(i).getGno());
			object.put("gname", list.get(i).getGname());
			object.put("gdate", list.get(i).getGdate());
			object.put("mno", list.get(i).getMno());
			object.put("mid", list.get(i).getMid());
			array.add(object);
		}
		
		//3.응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

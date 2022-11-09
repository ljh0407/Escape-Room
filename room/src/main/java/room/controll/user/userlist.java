package room.controll.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import room.model.dao.userDao;
import room.model.dto.USERDTO;

/**
 * Servlet implementation class userlist
 */
@WebServlet("/userlist")
public class userlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public userlist() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2.db요청
	ArrayList<USERDTO>list = userDao.getInstance().userlist();
			// 형변환
		JSONArray array = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("mno", list.get(i).getMno());
			object.put("mname", list.get(i).getMname());
			object.put("mid", list.get(i).getMid());
			object.put("mpw", list.get(i).getMpw());
			object.put("mphone", list.get(i).getMphone());
			array.add(object);
		
		}
	
	//3. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

}

package room.controll.nboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import room.model.dao.ndao;
import room.model.dto.NDTO;


@WebServlet("/nlist")
public class nlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public nlist() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		// 형변환
		ArrayList<NDTO> list = new ndao().getInstance().getlist();
		JSONArray array = new JSONArray();
		for(int i = 0; i< list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("nno",list.get(i).getNno() );
			object.put("ntitle",list.get(i).getNtitle() );
			object.put("ncontent",list.get(i).getNcontent() );
			object.put("ndate",list.get(i).getNdate() );
			object.put("nview",list.get(i).getNview() );
			object.put("mno",list.get(i).getMno() );
			object.put("mid",list.get(i).getMid() );
			array.add(object);
			
		}
		System.out.println( array.toString() );
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
		
	
		
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

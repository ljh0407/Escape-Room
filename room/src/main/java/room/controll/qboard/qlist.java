package room.controll.qboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import room.model.dao.qDao;
import room.model.dto.QDTO;

/**
 * Servlet implementation class qlist
 */
@WebServlet("/qlist")
public class qlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<QDTO> list = qDao.getIncetance().getlist();
		
		JSONArray array = new JSONArray();
		
		for( int i = 0 ;i<list.size() ; i++ ) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno() );
			object.put("btitle", list.get(i).getBtitle() );
			object.put("bcontent", list.get(i).getBcontent() );
			object.put("bfile", list.get(i).getBfile() );
			object.put("bdate", list.get(i).getBdate() );
			object.put("reply", list.get(i).getReply() );
			object.put("bview", list.get(i).getBview() );
			object.put("mno", list.get(i).getMno() );
			object.put("mid", list.get(i).getMid() );
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

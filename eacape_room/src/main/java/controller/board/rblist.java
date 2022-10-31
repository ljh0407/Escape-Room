package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.rbboardDto;

/**
 * Servlet implementation class rblist
 */
@WebServlet("/rblist")
public class rblist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글 출력
		
		ArrayList<rbboardDto> list = 
				new rbboardDto(rbno, rbtitle, rbscore, rbcontent, null, 0, mno).getRbview();
		// list -> json 변환
		JSONArray array = new JSONArray();
		for( int i = 0 ; i<list.size() ; i ++) {
			JSONObject object = new JSONObject();
			object.put("rbno", list.get(i).getRbno() );
			object.put("rbtitle", list.get(i).getRbtitle() );
			object.put("rbscore", list.get(i).getRbscore() );
			object.put("rbcontent", list.get(i).getRbcontent() );
			object.put("rbdate", list.get(i).getRbdate() );
			object.put("rbview", list.get(i).getRbview() );
			object.put("mno", list.get(i).getRb() );
		}
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rblist() {
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

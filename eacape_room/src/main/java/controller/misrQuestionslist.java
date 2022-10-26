package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.QuestionsDAO;
import model.boardDTO;

/**
 * Servlet implementation class misrQuestionslist
 */
@WebServlet("/board/misrQuestionslist")
public class misrQuestionslist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public misrQuestionslist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 없음
		//db[10/26]고은시
		ArrayList<boardDTO> list = new QuestionsDAO().getIncetance().getlist();
		JSONArray array = new JSONArray();
		for(int i = 0 ; i < list.size() ; i++) {
			JSONObject object = new JSONObject();
			object.put("bno",list.get(i).getBno());
			object.put("btitle",list.get(i).getBtitle());
			object.put("bcontent",list.get(i).getBcontent());
			object.put("bdate",list.get(i).getBdate());
			object.put("reply",list.get(i).getReply());
			object.put("mno",list.get(i).getMno());
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

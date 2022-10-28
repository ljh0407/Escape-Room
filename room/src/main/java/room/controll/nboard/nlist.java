package room.controll.nboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.DTD;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;
import room.model.dao.ndao;
import room.model.dto.NDTO;

/**
 * Servlet implementation class nlist
 */
@WebServlet("/nlist")
public class nlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public nlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}

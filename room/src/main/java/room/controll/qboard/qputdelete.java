package room.controll.qboard;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import room.model.dao.qDao;
import room.model.dto.QDTO;

@WebServlet("/qputdelete")
public class qputdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public qputdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	//////고은시[10/31]  삭제미완//////////
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//dao
		boolean result = new qDao().qdelete(bno);
		
		//응답
		response.getWriter().print(result);
		System.out.println(result);
	}
//////////////////////////////////////////5. 수정 및 삭제시 첨부파일 제거 메소드 [ file delete ]  //////////////////////////////////////////////
	public void deletefile( HttpSession session ,  String bfile ) {
		String deletepath = session.getServletContext().getRealPath("/qboard/qupload/"+ bfile);
		File file = new File( deletepath );
		if( file.exists() ) file.delete();   // 해당 경로에 존재하는 파일을 삭제
	}

}

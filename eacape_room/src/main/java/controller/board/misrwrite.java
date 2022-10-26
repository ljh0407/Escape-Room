package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.QuestionsDAO;
import model.misroomDao2;


@WebServlet("/board/misrwrite")
public class misrwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public misrwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 고은시 [10/26]파일 추가를 위해 방식 변경
		 * //고은시[10/24] String btitle = request.getParameter("btitle"); String bcontent
		 * = request.getParameter("bcontent"); // 회원번호 int mno =
		 * misroomDao2.getInstance().getMno((String)
		 * request.getSession().getAttribute("mid")); // db처리 boolean result =
		 * QuestionsDAO.getIncetance().write(btitle, bcontent, mno); //응답
		 * response.getWriter().print(result);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고은시[10/26] get -> post 이동 및 파일첨부 기능 추가
		//파일추가
		String upload = request.getSession().getServletContext().getRealPath("/misrupload");
		MultipartRequest multi = new MultipartRequest(
				request, 
				upload,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		//요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		// 파일요청 추가
		String bfile = multi.getFilesystemName("bfile");
		// 회원번호
		int mno = misroomDao2.getInstance().getMno((String) request.getSession().getAttribute("mid"));
		// db처리
		boolean result = QuestionsDAO.getIncetance().write(btitle, bcontent, bfile, mno);
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
	}

}

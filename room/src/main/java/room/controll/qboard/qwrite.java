package room.controll.qboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import room.model.dao.qDao;
import room.model.dao.userDao;

@WebServlet("/qwrite")
public class qwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public qwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일추가
	      String upload = request.getSession().getServletContext().getRealPath("/qboard/qupload");
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
	      int mno = userDao.getInstance().getMno((String) request.getSession().getAttribute("mid"));
	      System.out.println("회원번호 : " + mno );
	      // db처리
	      boolean result = qDao.getIncetance().write(btitle, bcontent, bfile, mno);
	      //응답
	      response.setCharacterEncoding("UTF-8");
	      response.getWriter().print(result);
	}
}

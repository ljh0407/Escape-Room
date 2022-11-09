package room.controll.qboard;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import room.model.dao.qDao;
import room.model.dto.QDTO;

/**
 * Servlet implementation class bfiledelete
 */
@WebServlet("/bfiledelete")
public class bfiledelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bfiledelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고은시 [11/07]
		//파일수정및 삭제
		int bno = (Integer)request.getSession().getAttribute("bno");
		//게시물 호출(선택한 게시물 번호 저장한거 불러오기)
		QDTO qdto = qDao.getIncetance().getqboard(bno);
		//DAO처리
		boolean result = qDao.getIncetance().bfiledelete(bno);
		//실제 파일 삭제 및 수정처리 	
		if(result) {
			//저장된 경로확인 후 파일 삭제처리
			String deletepath = request.getSession().getServletContext().getRealPath("/qupload/"+qdto.getBfile());
			//파일 삭제
			File file = new File(deletepath);
			if(file.exists()) {file.delete();}
		}
		//반환
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고은시수정[11/07]
		String uploadpath = request.getSession().getServletContext().getRealPath("/qboard/qupload");
		//파일 저장및 용량 설정
		MultipartRequest multi = new MultipartRequest(request,uploadpath,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		//수정요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		//수정게시물 번호호출
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		//수정되기전 게시물 정보 호출(다오에서 게시물 가져오기)
		QDTO qdto = qDao.getIncetance().getqboard(bno);
		
		//기존첨부파일 변경 여부판단
		boolean bfiledhange = true;
		
		if(bfile == null) { //만약 파일이 빈칸이면
			//다오에서 선택한 게시물의 파일을 그대로 가져간다[기존파일첨부]
			bfile = qDao.getIncetance().getqboard(bno).getBfile();
		}
		
		boolean result = qDao.getIncetance().qupdate(bno, btitle, bcontent, bfile);
		
		if(result) { //만약에 성공하면
			//기존파일 삭제
			if(bfiledhange) {
				String deletepath = request.getSession().getServletContext().getRealPath("/qupload/"+qdto.getBfile());
				File file = new File(deletepath);
				if(file.exists()) {file.delete();}
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
	
}

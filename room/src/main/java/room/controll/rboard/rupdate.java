package room.controll.rboard;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import room.model.dao.rdao;
import room.model.dto.RDTO;

/**
 * Servlet implementation class rupdate
 */
@WebServlet("/rboard/rupdate")
public class rupdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 1. 업로드폴더 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/rboard/rupload");
		
		// 첨부파일 있을시 멀티파트 사용
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy() );
		
		// 요청
		String rtitle = multi.getParameter("rtitle");		// 제목
		String rcontent = multi.getParameter("rcontent");	// 내용
		String rfile = multi.getParameter("rfile");			// 파일
		// 수정할 게시물의 번호
		int rno = (Integer)request.getSession().getAttribute("rno");
		// 수정 전 게시물 정보
		RDTO dto = rdao.getInstance().getrview(rno);
		// 기존첨부파일 변경 여부 판단
		boolean rfilechange = true;
		// 수정시 첨부파일 등록 없을경우 [ 기존첨부파일 호출 ]
		if( rfile == null ) { rfile = dto.getRfile(); rfilechange = false; } // 업데이트 성공시 [ 기존첨부파일 변경되었을때 ] 기존파일 삭제
		// dao 처리 업데이트 = 새로운 첨부파일
			boolean result = rdao.getInstance().rupdate( rno , rtitle , rcontent , rfile );
			if(result) { // 업데이트 성공시 [ 기존첨부파일 변경되었을때 ] 기존파일 삭제
			
			if( rfilechange ) { 
				String deletepath = request.getSession().getServletContext().getRealPath("/rupload/"+dto.getRfile() );
				File file = new File(deletepath); 
				if(file.exists()) file.delete();
			}
		}
		// 결과 반환
		response.getWriter().print(result);
	}
	private static final long serialVersionUID = 1L;
       
    public rupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}

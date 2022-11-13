package room.controll.qboard;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filedown
 */
@WebServlet("/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filedown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고은시 파일 다운[11/10]
		//요청
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/qboard/qupload/"+bfile) ;
		System.out.println("서블릿"+bfile);
		
		//해당 경로의 파일을 객체화[java에서 파일클래스 = file]
		File file = new File(uploadpath);
		System.out.println("파일"+file);
		
		response.setHeader( "Content-Disposition" , // 다운로드형식 HTML에서 지원 [ 브라우저 차이 있음 ]
                "attachment;filename="+ URLEncoder.encode(bfile, "UTF-8") );
		System.out.println("다운"+file);
		
		
		//HTTP에서 지원하는 다운로드형식 메소드 [response] (필수아님 없어도 실행됨)
		BufferedInputStream buff = new BufferedInputStream(new FileInputStream(file));
		System.out.println("버퍼"+buff);
		
		//파일의 바이트 길이만큼 배열선언
		byte[] bs = new byte[(int)file.length()];
		System.out.println("바이트읽기"+bs);
		
		//바이트(파일)읽어오기
		buff.read(bs);
		
		//읽어온 바이트 출력
		BufferedOutputStream stream = new BufferedOutputStream(response.getOutputStream());
		
		//배열에 존재하는 바이트 출력
		stream.write(bs);
		
		//아웃스트림 전송시 사용되는 임시 메모리 공간
		stream.flush();//출력스트림 버처 초기화
		buff.close();//입력스트림 닫기
		stream.close();//출력스트림 닫기[closs하면 버퍼 초기화]
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

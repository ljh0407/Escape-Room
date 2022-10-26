package room.controll.user;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.model.dao.userDao;

@WebServlet("/userpw")
public class userpw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userpw() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//요청
		String mid = request.getParameter("mid");
		String mphone = request.getParameter("mphone");
		//결과
		boolean result = userDao.getInstance().findPW(mid, mphone);
		System.out.println(result);
		//랜덤 문자열 저장할 공백임
		String ranstr = "";
		// 
		if(result) {
			//랜덤객체 생성
			Random ran = new Random();
			for(int i = 0 ; i <= 15 ; i++) {
				//숫자 -> 강제형변환[문자로 변환] *영소문자[아스키코드] = 97~122
				ranstr += (char)(ran.nextInt(26)+97);
			}
			userDao.getInstance().PWchage(mid, ranstr);
		}
		response.getWriter().printf(ranstr);	//ajax 전송
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Frist;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class End_session extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Cookie[] cookies=request.getCookies(); 
			if(cookies!=null){
				for(Cookie cookie:cookies){
					if(cookie.getName().equals("id")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						response.sendRedirect("profile.jsp");
					}
				}
			}else{
				
				response.sendRedirect("login.jsp");
			}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request,response);
	}
	
}


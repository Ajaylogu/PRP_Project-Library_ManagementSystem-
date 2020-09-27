package Frist;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Second.User;
import  Third.DB;
@WebServlet("/Controller")
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		User user=new User();
		Statement st=DB.getStatement();
		try {
			ResultSet rs,rs1;
			rs=st.executeQuery("select * from userBean where email='"+email+"' and passwrd='"+password+"'" );
			if(rs.next()){
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getString("date"));
				user.setGender(rs.getString("email"));
				Cookie loginCookie=new Cookie("id",user.getEmail());
				loginCookie.setMaxAge(30*60);
				response.addCookie(loginCookie);
				response.sendRedirect("profile.jsp");
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg","User Account doesn't exists create an account");
				rd.forward(request,response);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}
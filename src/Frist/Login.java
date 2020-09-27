package Frist;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Second.User;
import Third.DB;
@WebServlet("/Login")
public class Login  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
			Statement st=DB.getStatement();
			RequestDispatcher rd=null;
			ResultSet rs=null;
			User user=new User();
			user.setName(request.getParameter("name"));
			user.setDob(request.getParameter("dob"));
			user.setGender(request.getParameter("gender"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setConfirm(request.getParameter("confirm"));
			try {
				rs = st.executeQuery("select * from userBean where Email='"+user.getEmail()+"'");
				if(rs.next()){
					rd=request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg","Email already exists");
					rd.forward(request, response);
				}
				else{
					if(!user.getPassword().equals(user.getConfirm())){
						rd=request.getRequestDispatcher("index.jsp");
						request.setAttribute("msg","Password and Confirm Password doesn't match");
						rd.forward(request, response);
					}else{
						if(user.getName()!=""&&user.getGender()!=""&&user.getDob()!=""&&user.getEmail()!=""&&user.getPassword()!="") {
						st.executeUpdate("insert into userBean values('"+user.getName()+"','"+user.getGender()+"','"+user.getDob()+"','"+user.getEmail()+"','"+user.getPassword()+"')");
						rd=request.getRequestDispatcher("login.jsp");
						request.setAttribute("msg","Registered Successfully. You can login now!");
						rd.forward(request, response);
						}else {
							rd=request.getRequestDispatcher("index.jsp");
							request.setAttribute("msg","Fill the required Fields");
							rd.forward(request, response);
						}
					}
				}
			}catch (SQLException e1){
				e1.printStackTrace();
			}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		doGet(request,response);
	}
	
	
}


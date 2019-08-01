package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();


		out.println("<html>");
		out.println("<form action='CheckUserLogin' method='post'>");
		out.println("<table><caption><b><i>Customer Login</i></b></caption><br>");
		out.println("<tr><td><b><i>Username:</b></i></td><td><input type='text' name='username'></td></tr>");
		out.println("<tr><td><b><i>Password:</b></i></td><td><input type='password' name='password'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit'>");
		out.println("</form></html>");
		out.flush();
	}

}

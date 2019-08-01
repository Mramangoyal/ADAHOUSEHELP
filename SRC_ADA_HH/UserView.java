package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserView
 */
@WebServlet("/UserView")
public class UserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body><center>");
		out.println("<font size=12><b><a href='UserLogin'>LOGIN</a></b></font>");
		out.println("<form action='RegistrationSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>User Registration</i></b></h2>");

		out.println("<tr><td><b><i>Name:</b></i></td><td><input type='text' class='form-control' name='userfn' placeholder='First Name'> <input type='text' class='form-control' name='userln' placeholder='Last Name'></td></tr>");
		out.println("<tr><td><b><i>Contact Number:</b></i></td><td><input type='number' class='form-control' name='contact'></td></tr>");
		out.println("<tr><td><b><i>Email:</b></i></td><td><input type='email' class='form-control' name='email'></td></tr>");
		
		
		out.println("<tr><td><b><i>Choose City:</b></i></td><td><input type='radio' name='city' value='Indore'>Indore <input type='radio' name='city' value='Bhopal'>Bhopal <input type='radio' name='city' value='Ujjain'>Ujjain</td></tr>");
		
		out.println("<tr><td><b><i>Locality:</b></i></td><td><textarea name='locality' class='form-control' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>Enter a username<br> for yourself:</b></i></td><td><input type='text' class='form-control' name='username'></td></tr>");
		
		out.println("<tr><td><b><i>Password:</b></i></td><td><input type='password' class='form-control' name='pwd'></td></tr>");
		
		out.println("</table>");
		out.println("<input class='btn btn-success' type='submit'> <input class='btn btn-danger'  type='reset'>");
		out.println("</form></center></body></html>");
		out.flush();
	}

}

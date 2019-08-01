package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.EmployeeController;
import controller.UserLoginController;
import model.Employees;
import model.User;

/**
 * Servlet implementation class CheckUserLogin
 */
@WebServlet("/CheckUserLogin")
public class CheckUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		User u=UserLoginController.checkLogin(request.getParameter("username"), request.getParameter("password"));
		HttpSession ses=request.getSession();
		if(u!=null)
		{
			ses.putValue("SUSER", u);
	    	ses.putValue("LTIME", new java.util.Date());
	    	response.sendRedirect("UserHome");
		}
		else
		{
		out.println("Invalid Username/Password");	
		}
	}
	}



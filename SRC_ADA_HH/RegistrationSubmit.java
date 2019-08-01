package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import model.User;

/**
 * Servlet implementation class RegistrationSubmit
 */
@WebServlet("/RegistrationSubmit")
public class RegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		User u=new User();
		u.setName(request.getParameter("userfn")+" "+request.getParameter("userln"));
		u.setContact(request.getParameter("contact"));
		u.setEmail(request.getParameter("email"));
		u.setCity(request.getParameter("city"));
		u.setLocality(request.getParameter("locality"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("pwd"));
      
        
       boolean st=UserController.addNewRecord(u);
       out.println("<html>");
       if(st)
       { out.println("<b><font size=14>Thank You for Registering with us!</font></b><br><font size=8><a href='UserHome'>Go to Home Page</a></font>");}
       else
       {out.println("Registraton Failed!..<br><a href='UserView'>Register Again</a>");}
       out.println("</html>");  
       out.flush();       
       
       
       
       
     
	}

}

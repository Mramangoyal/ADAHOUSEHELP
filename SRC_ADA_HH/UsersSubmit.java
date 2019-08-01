package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.UserController;
import model.CookingHelper;
import model.User;

/**
 * Servlet implementation class UserSubmit
 */
@WebServlet("/UserSubmit")
public class UsersSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersSubmit() {
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
       { out.println("Thank You for Registering with us!<br>");}
       else
       {out.println("Registraton Failed!..<br><a href='UserView'>Register Again</a>");}
       out.println("</html>");  
       out.flush();       
       
       
       
       
     
	}

}

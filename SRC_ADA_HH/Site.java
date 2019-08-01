package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Site
 */
@WebServlet("/Site")
public class Site extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Site() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<table><tr><td>");
		out.println("<ul><b><font size=6>REGISTER/LOGIN</font></b>");
		out.println("<li><font size=4><a href='UserView' target=mw>New User?</a></font></li><br>");
		out.println("<li><font size=4><a href='UserLogin' target=mw>LOGIN</a></font></li>");
		out.println("</ul><br><br>");
		
		out.println("<ul><b><font size=6>Our Services..</font></b>");
		out.println("<li><font size=4><a href='UserView' target=mw>HOME</a></font></li><br>");
//out.println("<li><font size=4><a href='UserView' target=mw>CLEANING AID</a></font></li>");
		out.println("</ul><br><br>");
		
		
		out.println("</td><td><iframe name=mw width=900 height=900 frameborder=0 valign=top></td></tr></table>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}

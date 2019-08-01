package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;

/**
 * Servlet implementation class AdminHomePage
 */
@WebServlet("/AdminHomePage")
public class AdminHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		try{
			HttpSession ses=request.getSession();
		String ltime=ses.getValue("LTIME").toString();
		Admin A=(Admin)(ses.getValue("SADMIN"));
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Admin</title>");
		out.println("</head>");
		out.println("<body>");

		String nav="<i>Admin: "+A.getName()+"["+A.getAdminid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ltime+"</i>";
		out.println(nav+"<hr>");
		}
		catch(Exception e)
		{
			response.sendRedirect("AdminLoginPage");
		}
		out.println("<table><tr><td>");

		out.println("<ul><b><font size=10>Cooking Service</font></b>");
		out.println("<li><font size=7><a href='CookingHelperView' target=mw>New Helper</a></font></li>");
		out.println("<li><font size=7><a href='CookingHelperList' target=mw>Display Helpers</a></font></li>");
		out.println("</ul><br><br>");
		
		out.println("<ul><b><font size=10>Cleaning Service</font></b>");
		out.println("<li><font size=7><a href='CleaningHelperView' target=mw>New Helper</a></font></li>");
		//out.println("<li><font size=7><a href='CookingHelperList' target=mw>Display Helpers</a></font></li>");
		out.println("</ul><br><br>");
		
		
		out.println("</td><td><iframe name=mw width=900 height=900 frameborder=0 valign=top></td></tr></table>");
		out.println("</body>");
		out.println("</html>");

	}

}

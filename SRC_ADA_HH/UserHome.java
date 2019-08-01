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
import model.User;

/**
 * Servlet implementation class UserHome
 */
@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
PrintWriter out=response.getWriter();
		
		try{
			HttpSession ses=request.getSession();
		String ltime=ses.getValue("LTIME").toString();
		User u=(User)(ses.getValue("SUSER"));
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome!</title>");
		out.println("</head>");
		out.println("<body>");

		String nav="<i>Hello, "+u.getName()+"["+u.getUsername()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ltime+"</i>";
		out.println(nav+"<hr>");
		}
		catch(Exception e)
		{
			response.sendRedirect("UserLogin");
		}
		out.println("<b><font size=14 color='red'>We are here to help to find the best househelp! Go Search.</font></b>");
		out.println("<table><tr><td>");

		out.println("<ul><b><font size=12 color='green'>COOKING AID</font></b> ");
		out.println("<li><font size=10><a href='CookingHelperSearchReport' target=mw>Search via Time</a></font></li>");
		out.println("<li><font size=10><a href='CookingHelperGenderSearch' target=mw>Search by Helper's Gender?</a></font></li><br>");
		out.println("</ul><br><br>");
		
		out.println("<ul><b><font size=12 color='green'>CLEANING AID</font></b> ");
		out.println("<li><font size=10><a href='CleaningHelperTimeSearch' target=mw>Search via Time</a></font></li>");
		out.println("<li><font size=10><a href='CleaningHelperGenderSearch' target=mw>Search By Helper's Gender?</a></font></li><br>");
		out.println("</ul><br><br>");
		
		
		out.println("</td><td><iframe name=mw width=900 height=900 frameborder=0 valign=top></td></tr></table>");
		out.println("</body>");
		out.println("</html>");

	}

}

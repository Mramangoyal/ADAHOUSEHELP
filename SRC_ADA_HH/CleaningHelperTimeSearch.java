package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CleaningHelperTimeSearch
 */
@WebServlet("/CleaningHelperTimeSearch")
public class CleaningHelperTimeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CleaningHelperTimeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/SearchReport2.js'></script>");
			out.print("<html>"
					+ "<body><center><br><br><br><br><br>"
					+ "<table>"
					
					+ "<tr><td><b><i>Select the preferred number of working hours:</i></b></td><td><select id='timeid'></select></td></tr></table><br><br>"
				
					+ "<div id='result'></div>"
					+ "</body>"
					+ "<script src='asset/jquery-2.2.1.min.js'></script>"
					+ "<script src='asset/SearchReport2.js'></script>"
					+ "</center></body></html>");
			
	}

}

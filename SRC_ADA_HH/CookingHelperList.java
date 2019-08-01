package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CookingHelperController;
import controller.EmployeeController;
import model.Admin;

/**
 * Servlet implementation class CookingHelperList
 */
@WebServlet("/CookingHelperList")
public class CookingHelperList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookingHelperList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		try{
		String ltime=ses.getValue("LTIME").toString();
		Admin A=(Admin)(ses.getValue("SADMIN"));
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='asset/css/bootstrap.min.css' rel='stylesheet' type='text/css'>");
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
		try{
			
			ResultSet rs=CookingHelperController.displayAll();
			if(rs.next())
			{
				out.println("<html><body><center>");
				
				out.println("<table border=1 class='table table-bordered'  cellpadding=5 cellspacing=5 style='width:75%'><h2><b><i>Helper List</i></b></h2>");

			out.println("<tr><th>Helper</th><th>Age &<br> Gender</th><th>Religion</th><th>Preferred no. of<br>working hours</th><th>Experience(in years)</th><th>Documents<br>Available</th><th>Additional<br> Service</th><th>Food type &<br> Cuisine</th><th>Update</th>");
			do{
				out.println("<tr><td><b>Helper id: </b>"+rs.getString(1)+"<br><img src='coimage/"+rs.getString(12)+"' height=45 width=45><br>"+"<br><b>Name:</b>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"<br>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td></td></tr>");
				
				
			   }
			while(rs.next());
			out.println("</table>");
		
			
		}
			else
				System.out.println("records not found..");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.println("</center></body></html>");
		out.flush();
	}

}

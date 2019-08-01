package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CleaningHelperView
 */
@WebServlet("/CleaningHelperView")
public class CleaningHelperView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CleaningHelperView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/time.js'></script>");
		out.println("<script src='asset/gender.js'></script>");
		out.println("<html><body><center>");
		out.println("<form action='CleaningHelperSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Helper Register</i></b></h2>");

		out.println("<tr><td><b><i>Name:</b></i></td><td><input type='text' class='form-control' name='clfn' placeholder='First Name'> <input type='text' class='form-control' name='clln' placeholder='Last Name'></td></tr>");
		out.println("<tr><td><b><i>Age:</b></i></td><td><input type='number' class='form-control' name='age'></td></tr>");
		
		out.println("<tr><td><b><i>Gender:</b></i></td><td><select id='genderid' class='form-control' name='genderid'></select></td></tr>");
		out.println("<tr><td><b><i>Religion:</b></i></td><td><input type='text' class='form-control' name='religion'></td></tr>");
		out.println("<tr><td><b><i>Time(in hrs.) he/she can work for:</b></i></td><td><select id='timeid' class='form-control' name='timeid'></select></td></tr>");
		out.println("<tr><td><b><i>Experience(in yrs.):</b></i></td><td><input type='text' class='form-control' name='experience'></td></tr>");
		out.println("<tr><td><b><i>Documents:</b></i></td><td><input type='radio' name='doc' value='Adhaar Card'>Adhaar Card<input type='radio' name='doc' value='PAN Card'>PAN Card<br><input type='radio' name='doc' value='Ration Card'>Ration Card </td></tr>");
		
		out.println("<tr><td><b><i>Can additionally help in:</b></i></td><td><textarea name='service' class='form-control' rows='3' cols='25'></textarea></td></tr>");
		
		out.println("<tr><td><b><i>Photograph:</b></i></td><td><input type='file' class='form-control' name='photograph'></td></tr>");
		
		out.println("</table>");
		out.println("<input class='btn btn-success' type='submit'> <input class='btn btn-danger'  type='reset'>");
		out.println("</form></center></body></html>");
		out.flush();
	}

}

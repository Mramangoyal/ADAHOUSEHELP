package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import controller.CookingHelperController;
import controller.DB;
import controller.DbHelper;
import controller.IssueController;

/**
 * Servlet implementation class GetAllCooksByTime
 */
@WebServlet("/GetAllCooksByTime")
public class GetAllCooksByTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCooksByTime() {
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
		ResultSet rs=CookingHelperController.DisplayCookByTime(Integer.parseInt(request.getParameter("timeid")));
		ArrayList<JSONObject> obj=DB.JSONEngine(rs);
		out.println(obj);
	}

}

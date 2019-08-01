package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.CookingHelperController;

import model.CookingHelper;


/**
 * Servlet implementation class CookingHelperSubmit
 */
@WebServlet("/CookingHelperSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class CookingHelperSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookingHelperSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		CookingHelper co=new CookingHelper();
		co.setCookinghelpername(request.getParameter("cofn")+" "+request.getParameter("coln"));
		co.setAge(Integer.parseInt(request.getParameter("age")));
		co.setGender(Integer.parseInt(request.getParameter("genderid")));
		co.setReligion(request.getParameter("religion"));
		co.setHours(Integer.parseInt(request.getParameter("timeid")));
		co.setExperience(request.getParameter("experience"));
       co.setDocuments(request.getParameter("doc"));
        
        
        co.setService(request.getParameter("service"));
        co.setFoodtype(request.getParameter("ft"));
        co.setCuisine(request.getParameter("cuisine"));
       // E.setPhotograph(request.getParameter("eph"));
        Part P=request.getPart("photograph");
        FileUpload F=new FileUpload(P,"E:/HH/WebContent/coimage");
        co.setPhotograph(F.filename);
        
       boolean st=CookingHelperController.addNewRecord(co);
       out.println("<html>");
       if(st)
       { out.println("Record Submitted..<br><a href='CookingHelperView'>Add More Helpers</a>");}
       else
       {out.println("Failed to Submit Record..<br><a href='CookingHelperView'>Add More Helpers</a>");}
       out.println("</html>");  
       out.flush();       
       
       
       
       
       
       
	}

}

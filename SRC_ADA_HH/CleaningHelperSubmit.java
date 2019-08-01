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

import controller.CleaningHelperController;
import controller.CookingHelperController;
import model.CleaningHelper;
import model.CookingHelper;

/**
 * Servlet implementation class CleaningHelperSubmit
 */
@WebServlet("/CleaningHelperSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class CleaningHelperSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CleaningHelperSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		CleaningHelper cl=new CleaningHelper();
		cl.setCleaninghelpername(request.getParameter("clfn")+" "+request.getParameter("clln"));
		cl.setAge(Integer.parseInt(request.getParameter("age")));
		cl.setGender(request.getParameter("gender"));
		cl.setReligion(request.getParameter("religion"));
		cl.setHours(Integer.parseInt(request.getParameter("timeid")));
		cl.setExperience(request.getParameter("experience"));
		
       cl.setDocuments(request.getParameter("doc"));
        
        
        cl.setService(request.getParameter("service"));
       
       // E.setPhotograph(request.getParameter("eph"));
        Part P=request.getPart("photograph");
        FileUpload F=new FileUpload(P,"E:/HH/WebContent/climage");
        cl.setPhotograph(F.filename);
        
       boolean st=CleaningHelperController.addNewRecord(cl);
       out.println("<html>");
       if(st)
       { out.println("Record Submitted..<br><a href='CleaningHelperView'>Add More Helpers</a>");}
       else
       {out.println("Failed to Submit Record..<br><a href='CleaningHelperView'>Add More Helpers</a>");}
       out.println("</html>");  
       out.flush();       
       
	}

}

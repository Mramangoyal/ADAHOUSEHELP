package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.CleaningHelper;
import model.CookingHelper;
import model.Employees;

public class CleaningHelperController {
	public static boolean addNewRecord(CleaningHelper cl)
	{
		try{
			  Connection cn=DB.openConnection();
			  String query="insert into cleaninghelper(clname,age,gender,religion,timeid,experience,documents,service,photograph) values('"+cl.getCleaninghelpername()+"',"+cl.getAge()+",'"+cl.getGender()+"','"+cl.getReligion()+"','"+cl.getHours()+"','"+cl.getExperience()+"','"+cl.getDocuments()+"','"+cl.getService()+"','"+cl.getPhotograph()+"')";
			 boolean st=DB.executeUpdate(cn, query);
			 return(st);
			  
			}
			catch(Exception e)
				{
				System.out.println("Error:addNewRecord()"+e);
				}
			return(false);
				
			}
	public static ResultSet displayAll()
	{
		try{
			  Connection cn=DB.openConnection();
			  String query="select co.coid,co.coname,co.age,co.gender,co.religion,(select T.time from time T where T.timeid=co.timeid) as timeid,co.experience,co.documents,co.service,co.foodtype,co.cuisine,co.photograph from cookinghelper co";
			  
			ResultSet rs=DB.executeQuery(cn, query);
			 return(rs);
			  
			}
			catch(Exception e)
				{
				System.out.println("Error:displayAll()"+e);
				}
			return(null);
				
			}
	public static ResultSet DisplayCleanerByTime(int timeid) {
		try {
			Connection cn=DB.openConnection();
			ResultSet rs=DB.executeQuery(cn, "Select cl.clname,cl.age,(select G.gender from gender G where G.genderid=cl.genderid) as genderid,cl.religion, (select T.time from time T where T.timeid=cl.timeid) as timeid,cl.experience,cl.documents,cl.service,cl.photograph from cleaninghelper cl where cl.timeid="+timeid);
			//System.out.println("Select I.employeeid,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from product PR where PR.productid=I.productid) as product,I.transactionid,I.issuedate,(select E.employeename from employees E where E.employeeid=I.employeeid) as employee,I.purpose,I.quantity from issue where issuedate between '"+fromdate+"' and '"+todate+"'");
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet DisplayCleanerByGender(int genderid) {
		try {
			Connection cn=DB.openConnection();
			ResultSet rs=DB.executeQuery(cn, "Select cl.clname,cl.age,(select G.gender from gender G where G.genderid=cl.genderid) as genderid,cl.religion, (select T.time from time T where T.timeid=cl.timeid) as timeid,cl.experience,cl.documents,cl.service,cl.photograph from cleaninghelper cl where cl.genderid="+genderid);
			//System.out.println("Select I.employeeid,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from product PR where PR.productid=I.productid) as product,I.transactionid,I.issuedate,(select E.employeename from employees E where E.employeeid=I.employeeid) as employee,I.purpose,I.quantity from issue where issuedate between '"+fromdate+"' and '"+todate+"'");
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}

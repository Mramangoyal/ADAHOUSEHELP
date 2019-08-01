package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.CookingHelper;
import model.Employees;;

public class CookingHelperController {
	
public static boolean addNewRecord(CookingHelper co)
{
	try{
		  Connection cn=DB.openConnection();
		  String query="insert into cookinghelper(coname,age,genderid,religion,timeid,experience,documents,service,foodtype,cuisine,photograph) values('"+co.getCookinghelpername()+"',"+co.getAge()+",'"+co.getGender()+"','"+co.getReligion()+"','"+co.getHours()+"','"+co.getExperience()+"','"+co.getDocuments()+"','"+co.getService()+"','"+co.getFoodtype()+"','"+co.getCuisine()+"','"+co.getPhotograph()+"')";
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
		  String query="select co.coid,co.coname,co.age,(select G.gender from gender G where G.genderid=co.genderid) as genderid,co.religion,(select T.time from time T where T.timeid=co.timeid) as timeid,co.experience,co.documents,co.service,co.foodtype,co.cuisine,co.photograph from cookinghelper co";
		  
		ResultSet rs=DB.executeQuery(cn, query);
		 return(rs);
		  
		}
		catch(Exception e)
			{
			System.out.println("Error:displayAll()"+e);
			}
		return(null);
			
		}
public static ResultSet displayById(int eid )
{
	try{
		  Connection cn=DbHelper.openConnection();
		  String query="select E.employeeid,E.employeename,E.fname,E.dob,E.gender,E.permanentaddress,(select S.statename from states S where S.stateid=E.pstate),(select C.cityname from cities  C where C.cityid=E.pcity),currentaddress,(select S.statename from states S where S.stateid=E.cstate),(select C.cityname from cities C where C.cityid=E.ccity),E.contactno,E.mobileno,E.emailid,E.qualification,E.designation,E.basicsalary,E.password,E.photograph,E.pstate,E.pcity,E.cstate,E.ccity from employees E where E.employeeid="+eid;
		  System.out.println(query);
		ResultSet rs=DbHelper.executeQuery(cn, query);
		 return(rs);
		  
		}
		catch(Exception e)
			{
			System.out.println("Error:displayAll()"+e);
			}
		return(null);
			
		}
public static boolean deleteRecord(int eid)
{
	try{
		  Connection cn=DbHelper.openConnection();
		  String query="delete from employees where employeeid="+eid;
		 boolean st=DbHelper.executeUpdate(cn, query);
		 return(st);
		  
		}
		catch(Exception e)
			{
			System.out.println("Error:addNewRecord()"+e);
			}
		return(false);
			
		}

public static ResultSet DisplayCookByTime(int timeid) {
	try {
		Connection cn=DB.openConnection();
		ResultSet rs=DB.executeQuery(cn, "Select co.coname,co.age,(select G.gender from gender G where G.genderid=co.genderid) as genderid,co.religion, (select T.time from time T where T.timeid=co.timeid) as timeid,co.experience,co.documents,co.service,co.foodtype,co.cuisine,co.photograph from cookinghelper co where co.timeid="+timeid);
		//System.out.println("Select I.employeeid,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from product PR where PR.productid=I.productid) as product,I.transactionid,I.issuedate,(select E.employeename from employees E where E.employeeid=I.employeeid) as employee,I.purpose,I.quantity from issue where issuedate between '"+fromdate+"' and '"+todate+"'");
		return(rs);
	}catch(Exception e) {
		System.out.println(e);
	}
	return null;
}
public static ResultSet DisplayCookByGender(int genderid) {
	try {
		Connection cn=DB.openConnection();
		ResultSet rs=DB.executeQuery(cn, "Select co.coname,co.age,(select G.gender from gender G where G.genderid=co.genderid) as genderid,co.religion, (select T.time from time T where T.timeid=co.timeid) as timeid,co.experience,co.documents,co.service,co.foodtype,co.cuisine,co.photograph from cookinghelper co where co.genderid="+genderid);
		//System.out.println("Select I.employeeid,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from product PR where PR.productid=I.productid) as product,I.transactionid,I.issuedate,(select E.employeename from employees E where E.employeeid=I.employeeid) as employee,I.purpose,I.quantity from issue where issuedate between '"+fromdate+"' and '"+todate+"'");
		return(rs);
	}catch(Exception e) {
		System.out.println(e);
	}
	return null;
}
}

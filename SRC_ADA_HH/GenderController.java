package controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class GenderController {
	public static ResultSet displayAll()
	{
		try{
			  Connection cn=DB.openConnection();
			  String query="select G.genderid,G.gender from gender G";
			  
			ResultSet rs=DB.executeQuery(cn, query);
			 return(rs);
			  
			}
			catch(Exception e)
				{
				System.out.println("Error:displayAll()"+e);
				}
			return(null);
				
			}
}

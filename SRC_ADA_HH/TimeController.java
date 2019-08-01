package controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class TimeController {
	public static ResultSet displayAll()
	{
		try{
			  Connection cn=DB.openConnection();
			  String query="select T.timeid,T.time from time T";
			  
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

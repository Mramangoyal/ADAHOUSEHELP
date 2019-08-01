package controller;

import java.sql.Connection;
import java.sql.ResultSet;



import model.User;

public class UserController {
	public static boolean addNewRecord(User u)
	{
		try{
			  Connection cn=DB.openConnection();
			  String query="insert into user(name,contact,emailid,city,locality,username,password) values('"+u.getName()+"','"+u.getContact()+"','"+u.getEmail()+"','"+u.getCity()+"','"+u.getLocality()+"','"+u.getUsername()+"','"+u.getPassword()+"')";
			System.out.println(query);
			  boolean st=DB.executeUpdate(cn, query);
			 return(st);
			  
			}
			catch(Exception e)
				{
				System.out.println("Error:addNewRecord()"+e);
				}
			return(false);
				
			}
	
				
			}
	
	
	

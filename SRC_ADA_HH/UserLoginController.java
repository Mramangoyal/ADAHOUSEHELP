package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Admin;
import model.User;

public class UserLoginController {
	public static User checkLogin(String username,String password)
	{
		try{
			
			 Connection cn=DB.openConnection();
			 String query="select * from user where username='"+username+"' and password='"+password+"'";
				System.out.println(query);
				  ResultSet rs=DB.executeQuery(cn, query);
				  User u=new User();
				  if(rs.next())
				  {
					  u.setUsername(rs.getString(7));
					  
					  u.setName(rs.getString(2));
					  return u;
					  
				  }
				  return null;
			
		}
		catch(Exception e)
		{
			System.out.println("error checkLogin:"+e);
			return null;
		}

}
}
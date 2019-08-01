package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONObject;

public class DB {
	public static Connection openConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hh","root","123");
		return cn;
		}
		
	catch(Exception e)
		{
		System.out.println("Error openConnection():"+e);
		}
		return(null);
	}
	public static boolean executeUpdate(Connection cn,String query)
	{
		try{
			Statement smt=cn.createStatement();
			smt.executeUpdate(query);
			return(true);
			
		}
		catch(Exception e)
		{
			System.out.println("Error executeUpdate():"+e);
		}
		return(false);
	}

	public static ResultSet executeQuery(Connection cn,String query)
	{
		try{
			Statement smt=cn.createStatement();
			ResultSet rs=smt.executeQuery(query);
			return rs;
			
		}
		catch(Exception e)
		{
			System.out.println("Error executeQuery():"+e);
		}
		return(null);
	}
	

public static ArrayList<JSONObject> JSONEngine(ResultSet rs)
{
	ArrayList<JSONObject> res=new ArrayList<JSONObject>();
	try
	{
		ResultSetMetaData rsmt=rs.getMetaData();
		int columncnt=rsmt.getColumnCount();
		ArrayList<String> col=new ArrayList<String>();
		for(int i=1;i<=columncnt;i++)
		{
			col.add(rsmt.getColumnName(i).toUpperCase());
		}
		
		while(rs.next())
		{
			JSONObject obj=new JSONObject();
			for(int i=1;i<=columncnt;i++)
			{
			String key=col.get(i-1);
			String value=rs.getString(i);
			obj.put(key,value);
			}
			res.add(obj);
		}
	} catch(Exception e) {
		e.printStackTrace();
		} finally {
		try {
		rs.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return res;
		}
	
 


}

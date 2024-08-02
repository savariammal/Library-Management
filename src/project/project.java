package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class project {
       int id;
       String name,dep,address;
       int phno;
     Scanner s=new Scanner(System.in);
     
     void addproject()
     {
    	 try
    	 {
    		 System.out.println("Enter project id:");
    		 id=s.nextInt();
    		 System.out.println("Enter project name:");
    		 name=s.next();
    		 System.out.println("Enter project department:");
    		 dep=s.next();
    		 System.out.println("Enter project address:");
    		 address=s.next();
    		 System.out.println("Enter project phno:");
    		 phno=s.nextInt();
    		 
    		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","savari20");
   		  PreparedStatement ps=con.prepareStatement("insert into project values(?,?,?,?,?)");
   			   ps.setInt(1,id);
   			   ps.setString(2,name);
   			   ps.setString(3,dep);
   			   ps.setString(4,address);
   			   ps.setInt(5,phno);
   			   ps.executeUpdate();
   			   con.close();
   			   System.out.println("Data saved...");
   			 
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
	public static void main(String[] args) 
	{
		project p=new project();
		p.addproject();

	}

}

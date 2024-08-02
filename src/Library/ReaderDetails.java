package Library;
import java.util.Scanner;
import java.sql.*;
public class ReaderDetails {
             int readerid;
             String name;
             String email;
             long phonenumber;
             String address;
          Scanner s=new Scanner(System.in);
       void reader()
       {
    	   try
    	   {
    		   System.out.println("Enter Reader Id:");
    		     readerid=s.nextInt();
    		   System.out.println("Enter Reader Name:");
    		     name=s.next();
    		   System.out.println("Enter Reader Email:");
    		     email=s.next();
    		   System.out.println("Enter Reader Phonenumber:");
    		      phonenumber=s.nextLong();
    		    System.out.println("Enter Reader Address:");
    		       address=s.next();
    		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydata","root","savari20");
    		   PreparedStatement ps=con.prepareStatement("insert into reader values(?,?,?,?,?)");
   			   ps.setInt(1,readerid);
   			   ps.setString(2,name);
   			   ps.setString(3,email);
   			   ps.setLong(4,phonenumber);
   			   ps.setString(5,address);
   			   ps.executeUpdate();
   			   con.close();
   			   System.out.println("Data saved...");
   			 }
   			 
   			 catch(Exception e)
   			 {
   				 System.out.println("Data not saved...");
   			 }
   		}
       
	    void addreader() {
	        try {
	            System.out.println("Enter the Reader Id:");
	               readerid = s.nextInt();
	            System.out.println("Enter the Reader name:");
	               name= s.next();
	            System.out.println("Enter the Reader email:");
	               email= s.next();
	            System.out.println("Enter Reader Phonenumber:");
	                phonenumber= s.nextLong();
	            System.out.println("Enter Reader Address:");
	                address= s.next();

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata", "root", "savari20");
	            PreparedStatement ps = con.prepareStatement("insert into reader values(?,?,?,?,?)");
	            ps.setInt(1,readerid);
	            ps.setString(2,name);
	            ps.setString(3,email);
	            ps.setLong(4,phonenumber);
	            ps.setString(5,address);
	            ps.executeUpdate();
	            con.close();
	            System.out.println("Data saved...");
	        }
	        catch (Exception e) 
	        {
	         
	            System.out.println("Data not saved...");
	        }
	    }

	    void updatereader() {
	        try {
	            System.out.println("Enter the Reader Id:");
	            readerid = s.nextInt();
	            System.out.println("Enter the Reader Name:");
	            name = s.next();

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata", "root", "savari20");
	            PreparedStatement ps = con.prepareStatement("update reader set name=? where reader_id=?");
	            ps.setString(1,name);
	            ps.setInt(2, readerid);
	            int r = ps.executeUpdate();
	            con.close();
	            System.out.println((r != 0) ? "Data updated..." : "Invalid reader ID");
	        } 
	        catch (Exception e) 
	        {
	            
	           // System.out.println("Data not updated...");
	        	System.out.println(e);
	        }
	    }

	    void deletereader() 
	    {
	        try {
	            System.out.println("Enter the Reader Name:");
	            name = s.next();

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata", "root", "savari20");
	            PreparedStatement ps = con.prepareStatement("delete from reader where name=?");
	            ps.setString(1,name);
	            int r = ps.executeUpdate();
	            con.close();
	            System.out.println((r != 0) ? "Data deleted..." : "Invalid reader ID");
	        } 
	        catch (Exception e) 
	        {
	          
	            //System.out.println("Data not deleted...");
	        	System.out.println(e);
	        }
	    }
void findreader() {
	        try {
	            System.out.println("Enter the reader name:");
	            name = s.next();
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata", "root", "savari20");
	            PreparedStatement ps = con.prepareStatement("select * from reader where name=?");
	            ps.setString(1,name);
	            ResultSet r = ps.executeQuery();
	            int count = 0;
	            while (r.next()) {
	                System.out.println("Reader Id=" + r.getInt(1));
	                System.out.println("Reader Name=" + r.getString(2));
	                System.out.println("Reader Email=" + r.getString(3));
	                System.out.println("Reader Phonenumber=" + r.getLong(4));
	                System.out.println("Reader Address=" + r.getString(5));
	                count = 1;
	            }
	            con.close();
	        if (count == 0) {
	                System.out.println("Reader not found");
	            }
	        }
	      catch (Exception e)
	        {
	            System.out.println("Data not found...");
	        }
	    }
  void printreader() 
	    {
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata", "root", "savari20");
	            Statement ps = con.createStatement();
	            ResultSet r = ps.executeQuery("select * from reader");
	            int count = 0;
	      while (r.next()) {
	                System.out.println("Reader Id=" + r.getInt(1));
	                System.out.println("Reader Name=" + r.getString(2));
	                System.out.println("Reader Email=" + r.getString(3));
	                System.out.println("Reader Phonenumber=" + r.getLong(4));
	                System.out.println("Reader Address=" + r.getString(5));
	                System.out.println(".............");
	                count = 1;
	            }
	            con.close();
	       if (count == 0) 
	       {
	                System.out.println("No data found");
	            }
	        }
	       catch (Exception e) 
	        {
	        
	            System.out.println("Data not found...");
	        }
	    
  }
}

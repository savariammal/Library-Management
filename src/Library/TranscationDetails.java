package Library;
import java.util.Scanner;
import java.sql.*;
public class TranscationDetails {
	        int transcationid;
	        int bookId;
	       // String Readername;
	        int ReaderId;
	        String returndate;
           int fineamount;
         Scanner s=new Scanner(System.in);
    void addtranscation()
    {
    	 try
    	 {
    		System.out.println("Enter the Transcation Id:");
    		     transcationid =s.nextInt();
    		System.out.println("Enter the Book Id:");
    		    bookId=s.nextInt();
    	  // System.out.println("Enter the Reader name:");
    	     //  Readername=s.next();
    		System.out.println("Enter the Reader Id:");
    		     ReaderId=s.nextInt();
    	    System.out.println("Enter the Return Date:");
    	       returndate=s.next();
    	    System.out.println("Enter the Fine Amount:");
    	     fineamount=s.nextInt();
    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/librarydata","root","savari20");
    	   PreparedStatement ps1=con.prepareStatement("select * from books where book_id=?");
    	       ps1.setInt(1,bookId);
    	       ps1.close();
    	   PreparedStatement ps2=con.prepareStatement("select * from reader where reader_id=?");
    	      ps2.setInt(1, ReaderId);
    	      ps2.close();
    	      PreparedStatement ps=con.prepareStatement("insert  into transcations (tid,bid,rid,returndate,fineamount) values(?,?,?,?,?)");
    	      ps.setInt(1,transcationid);
    	      ps.setInt(2,bookId);
    	      ps.setInt(3,ReaderId);
    	      ps.setString(4,returndate);
    	      ps.setInt(5,fineamount);
    	     ps.executeUpdate();
    	     con.close();
    	   System.out.println("Data saved...");
    	 }
   catch(Exception e)
    	 {
    		//System.out.println("Data not saved...");
	        System.out.println(e); 
    	 }
    }
   void deletetranscation()
    {
    	 try
    	 {
    	   System.out.println("Enter the Transcation Id:");
    		   transcationid =s.nextInt();
    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/librarydata","root","savari20");
    	   PreparedStatement ps=con.prepareStatement("delete from transcations where tid=?");
    	   ps.setInt(1,transcationid);
    	   int r=ps.executeUpdate();
    	   con.close();
    	   System.out.println((r!=0)?"Data updated...":"Invalid Id");
    	
    	 }
    	 catch(Exception e)
    	 {
    		// System.out.println("Data not saved...");
    		 System.out.println(e);
    	 }
    
   
	    }
	 }
   

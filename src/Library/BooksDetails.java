package Library;
import java.util.Scanner;
import java.sql.*;
public class BooksDetails {
          
	      int bookid;
	      String title;
	      String author;
	      int price;
	      int availablecopies;

	   Scanner s=new Scanner(System.in);
void addbooks()
	 {
		try
		 {
		  System.out.println("Enter the book Id:");
			 bookid=s.nextInt();
		  System.out.println("Enter the title name:");
			 title=s.next();
		  System.out.println("Enter the author name:");
		    author=s.next();
		  System.out.println("Enter book price:");
		    price=s.nextInt();
		  System.out.println("Enter available copies:");
		    availablecopies=s.nextInt();
		 
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydata","root","savari20");
		  PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?,?,?)");
			   ps.setInt(1,bookid);
			   ps.setString(2,title);
			   ps.setString(3,author);
			   ps.setInt(4,price);
			   ps.setInt(5,availablecopies);
			   ps.executeUpdate();
			   con.close();
			   System.out.println("Data saved...");
			 }
			 
			 catch(Exception e)
			 {
				 System.out.println("Data not saved...");
			 }
		}
	 void updatebooks()
		{
			 try
			 {
				System.out.println("Enter the book Id:");
				  bookid =s.nextInt();
				System.out.println("Enter the book title:");
				  title=s.next();
			   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/librarydata","root","savari20");
			   PreparedStatement ps=con.prepareStatement("update books set title=? where book_id=?");
			   ps.setString(1,title);
			   ps.setInt(2, bookid);
			   int r=ps.executeUpdate();
			   con.close();
			   System.out.println((r!=0)?"Data updated...":"Invalid Id");
			
			 }
			 catch(Exception e)
			 {
				 System.out.println("Data not saved...");
			 }
		}
	void deletebooks() {
	        try {
	           
	        	System.out.println("Enter the Book Id:");
	                 bookid = s.nextInt();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata","root","savari20");
	            PreparedStatement ps = con.prepareStatement("delete from books where book_id=?");
	            ps.setInt(1, bookid);
	            int r = ps.executeUpdate();
	            con.close();
	            System.out.println((r!= 0) ? "Data deleted..." : "Invalid book ID");
	        } 
	        catch (Exception e) 
	        {
	           System.out.println(e);
	        }
	    }
 void findbooks()
		{
			try
			{
				  System.out.println("Enter the Author name:");
				       author=s.next();
				   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/librarydata","root","savari20");
				   PreparedStatement ps=con.prepareStatement("select * from books where author=?");
				   ps.setString(1,author);
				   ResultSet r= ps.executeQuery();
				   int count=0;
				   while(r.next())
				   {
					   System.out.println("Book Id="+r.getInt(1));
					   System.out.println("Book Title="+r.getString(2));
					   System.out.println("Author Name="+r.getString(3));
					   System.out.println("Book Price="+r.getInt(4));
					   System.out.println("Available copies="+r.getInt(5));
					   count=1;
					   
				   }
				 con.close();
				  
			if(count==0)
			{
				System.out.println("Select Name");
			}
		}
		   catch(Exception e)
			{
				 System.out.println("Data not saved...");
			  
			}
		}
	void printbooks() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/librarydata", "root", "savari20");
            Statement ps = con.createStatement();
            ResultSet r = ps.executeQuery("select * from books");
            int count = 0;
            while (r.next()) {
                System.out.println("Book Id=" + r.getInt(1));
                System.out.println("Book Title=" + r.getString(2));
                System.out.println("Book Author=" + r.getString(3));
                System.out.println("Book Price=" + r.getInt(4));
                System.out.println("Available Copies=" + r.getInt(5));
                System.out.println("...................");
                count = 1;
            }
            con.close();
            if (count == 0) {
                System.out.println("No data found");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Data not found...");
        }
    }

  }

	
	
	

	
	   
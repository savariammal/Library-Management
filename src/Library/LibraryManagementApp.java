package Library;

import java.util.Scanner;

public class LibraryManagementApp {
	   
public static void main(String[]args)
{
	Scanner s=new Scanner(System.in);
	
	System.out.println("Enter the Admin Username:");
     	String username=s.nextLine();
	
	System.out.println("Enter the Admin Password:");
	    String password=s.nextLine();
	
      	Login login=new Login();
	if(username.equals("library") && password.equals("pass"))
	{
		System.out.println("Admin Login Succcesfully");
     System.out.println("*************************************************");
	
      System.out.println("Library Management System:");
   while(true)
   {
	   System.out.println("\n1.BooksDetails\n2.ReaderDetails\n3.TranscationDetails\n4.Exit\nSelect any one:");
              
	   int choice = s.nextInt();

       switch(choice)
       {
       case 1:
    	   BooksDetails books=new BooksDetails();
    	
   while(true)
     {
      System.out.println("\n1.Add Books\n2.Update Books\n3.Delete Books\n4.Print Books\n5.Exit\nSelect any one:");
            int c = s.nextInt();
          switch (c)
            {
            case 1:
              books.addbooks();
              break;
            case 2:
              books.updatebooks();
              break;
            case 3:
              books.deletebooks();
             break;
            case 4:
              books.printbooks();
              break;
            case 5:
              System.out.println("Thank You!!");
           // System.exit(0);
              break;
            default:
              System.out.println("Invalid choice.Please choose again.");
              break;
            }
            if(c==5)
              break;
            }
          break;
        
       case 2:
    	   
    	   ReaderDetails read=new ReaderDetails();
    	   while(true)
    	   {
    		 System.out.println("\n1.Add Reader Details\n2.Update Reader Details\n3.Delete Reader Details\n4.Print Reader Details\n5.Exit\n Select any one:");    
    	       int n=s.nextInt();
    	      switch(n)
    	      {
    	   case 1:
               read.addreader();
               break;
             case 2:
               read.updatereader();
               break;
             case 3:
               read.deletereader();
              break;
             case 4:
               read.printreader();
               break;
             case 5:
               System.out.println("Thank You!!");
               break;
             default:
               System.out.println("Invalid choice.Please choose again.");
               break;
    	     }
    	    if(n==5)
    	     break;
    	   }
    	   break;
    	   
       case 3:
    	   TranscationDetails trans=new TranscationDetails();
    	   
    	   while(true)
    	   {
    		 System.out.println("\n1.Add Transcation Details\n2.Update Transcation Details\n3.Delete Transcation Details\n4.Print Transcation Details\n5.Exit\nSelect any one:");    
    	       int n=s.nextInt();
    	      switch(n)
    	      {
    	   case 1:
    		   trans.addtranscation();
               break;
             case 2:
            	 trans.deletetranscation();
              break;
             case 3:
               System.out.println("Thank You!!");
               break;
             
             default:
               System.out.println("Invalid choice.Please choose again.");
               break;
    	     }
    	    if(n==4)
    	     break;
    	   }
    	   break;
    
       case 4:
    	   
    	 System.out.println("Thank You...");
    	 //System.exit(0);
    	 default:
  
    System.out.println("Invalid choice.Please choose again.");
    break;
   }
  }
}
else
	{

     System.out.println("Invalid Login...");	
}
}
}


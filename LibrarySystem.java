
public class LibrarySystem  {

public static void main(String args[])
{
   Library L1=new Library();
      
   Item nn=new book("Harry Potter","Rold Dahl",2001,2,23);

   L1.viewByitem(nn);
   L1.displayMenu();

   
}
}
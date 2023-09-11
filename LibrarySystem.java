import java.util.Scanner;

public class LibrarySystem  {
  


public static void main(String args[])
{
    String title, author;
    int year;
    Scanner obj=new Scanner(System.in);
    System.out.println("Enter Book Title");
    title=obj.nextLine();

    System.out.println("Enter Author Title");
    author=obj.nextLine();

    System.out.println("Enter Year of publication");
    year=obj.nextInt();

    Book b1=new Book(title, author, year);
    b1.display();
    
}
}

class Book{
     public static int nextID=0;
   public int id;
   public String title;
   public String author;
   public int year;

public Book(String t, String a,int y)
{
  nextID++;
  id=nextID;
  title=t;
  author=a;
  year=y;

}

public void display()
{
    System.out.println("\nID : "+id+" Title : "+title+" by "+author+" ("+year+")");
}

}
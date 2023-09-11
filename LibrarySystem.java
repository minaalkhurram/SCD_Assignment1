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

    book b1=new book(title, author, year);
    b1.display();
    
}
}
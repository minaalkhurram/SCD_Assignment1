import java.util.Scanner;
import java.util.ArrayList;

public class LibrarySystem  {
  
public static void main(String args[])
{
    String title, author;
    int year;
      ArrayList pubslist=new ArrayList();
pubslist.add("hello");
pubslist.add("world");
for(int i=0;i<pubslist.size();i++)
{
    System.out.print(pubslist.get(i)+",");

}
System.out.print("\n");
    Scanner obj=new Scanner(System.in);
    System.out.println("Enter Book Title");
    title=obj.nextLine();

    System.out.println("Enter Author Title");
    author=obj.nextLine();

    System.out.println("Enter Year of publication");
    year=obj.nextInt();
      System.out.println("Enter popcount ");
    int pop;
    pop=obj.nextInt();
      System.out.println("Enter cost");
    int c;
    c=obj.nextInt();

    Item b1=new book(title, author, year,pop,c);
    b1.display();
      System.out.println("Enter mag Title");
    title=obj.nextLine();

    System.out.println("Enter publisher Title");
    author=obj.nextLine();


      System.out.println("Enter popcount ");
    pop=obj.nextInt();
      System.out.println("Enter cost");
     c=obj.nextInt();
    Item m1=new Magazine(title,author,pubslist,pop,c);
    m1.display();
}
}
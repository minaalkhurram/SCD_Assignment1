public class book{
     public static int nextID=0;
   public int id;
   public String title;
   public String author;
   public int year;

public book(String t, String a,int y)
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
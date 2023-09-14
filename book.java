public class book extends Item{
 public static int nextID=0;
   public String author;
   public int year;

public book(String t, String a,int y,int popCount,int c)
{
    super(t,popCount,c);

  nextID++;
  author=a;
  year=y;

}


public void display()
{
    super.display();
    System.out.println(" by "+author+" ("+year+")");
}
public void calculateCost()
{

}

}
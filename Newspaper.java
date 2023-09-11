import java.util.Date;

public class Newspaper extends Item {
    private String publisher;
    private Date date=new Date();
    
public Newspaper(String t, String p,Date d,int popCount,int c)
{
    super(t,popCount,c);
    publisher=p;
    date=d;


}
public void display()
{
    super.display();
    System.out.println(" by "+publisher+" ("+date+")");
}
public void calculateCost()
{

}
    
}

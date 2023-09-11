import java.time.LocalDate;
import java.util.Date;

public class Newspaper extends Item {
    private String publisher;
    private String date;
    
public Newspaper(String t, String p,int popCount,String d,int c)
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

import java.util.ArrayList;
import java.util.List;

public class Magazine extends Item {

    protected String publisher;
    private ArrayList<String> authorslist=new ArrayList<>();

public Magazine(String t, String p,ArrayList<String> lists,int popCount,int c)
{
    super(t,popCount,c);

  publisher=p;
  authorslist=lists;
  
}

public void display()
{
    super.display();
    System.out.print(" by "+publisher);
    for(int i=0;i<authorslist.size();i++)
    {
        System.out.print(authorslist.get(i)+",");

    }
    System.out.print("\n");
}
public void setpublisher(String x)
{
  publisher=x;
}

@Override
public int calculateCost()
{

  return cost*popularityCount;

}

    
}

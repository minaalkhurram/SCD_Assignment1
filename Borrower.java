import java.util.ArrayList;

public class Borrower {
    
    private String name;
    private ArrayList<Item> borrowed=new ArrayList<>();

    Borrower(String nn)
    {
        name=nn;
    }
    public void addBorrowed(Item i)
    {
        borrowed.add(i);

    }
    public String getname()
    {
        return name;
    }
    public void view()
    {
        System.out.println("\nBorrower : "+name+"\n Items : ");
        for(int i=0;i<borrowed.size();i++)
        {
            borrowed.get(i).display();
        }
    }
    public boolean checkExsiting(int id)
    {
        for(int i=0;i<borrowed.size();i++)
        {
            if(borrowed.get(i).getID()==id)
            {
                System.out.println("You have already borrowed this item before");
                return false;
            }
        }
        return true;
    }
}

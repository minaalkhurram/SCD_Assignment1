import java.util.ArrayList;

public class Borrower {
    
    public String name;
    private ArrayList<Item> currentBorrowed=new ArrayList<>();
    private ArrayList<Item> totalBorrowed=new ArrayList<>();

    Borrower(String nn)
    {
        name=nn;
    }
    public void addBorrowed(Item i)
    {
        currentBorrowed.add(i);
        totalBorrowed.add(i);
    }
    public String getname()
    {
        return name;
    }
    public void view()
    {
        System.out.println("\nBorrower : "+name+"\n Items : ");
        for(int i=0;i<currentBorrowed.size();i++)
        {
            currentBorrowed.get(i).display();
        }
    }
    public boolean checkExsiting(int id)
    {
        for(int i=0;i<totalBorrowed.size();i++)
        {
            if(totalBorrowed.get(i).getID()==id)
            {
                System.out.println("You have already borrowed this item before");
                return false;
            }
        }
        return true;
    }
    public void removeBorrow(int id)
    {
         for(int i=0;i<currentBorrowed.size();i++)
        {
            if(currentBorrowed.get(i).getID()==id)
            {
                System.out.println("hello");
                currentBorrowed.remove(i);
            }
        }

    }
}

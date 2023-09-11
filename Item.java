public class Item {
   private String title;
   private boolean isBorrowed;
   private int popularityCount;
   private static int id=0;
   private int cost;

   Item(String t,int popCount,int c)
   {
    id++;
    title=t;
    popularityCount=popCount;
    cost=c;
   }
   public void display()
   {
    System.out.print("\n ID : "+id+" Title : "+title);

   }
   public void calculateCost()
   {

   }
    
}

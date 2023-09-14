public class Item implements configuration {
   private String title;
   private boolean isBorrowed;
   private int popularityCount;
   private static int id=1;
   private int myID;
   private int cost;

   Item(String t,int popCount,int c)
   {
    myID=id;
    id++;
    title=t;
    popularityCount=popCount;
    cost=c;
   }
   public void display()
   {
    System.out.print("\n ID : "+myID+" Title : "+title);

   }
   public void setTitle(String x)
   {
      title=x;
      
     }

   public void calculateCost()
   {

   }
   public int getID()
   {
    return myID;
   }
}

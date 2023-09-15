import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;

public class Library {
   private ArrayList<Item> ItemList=new ArrayList<>();
   private ArrayList<Borrower> borrowers=new ArrayList<>();
   
   public Library(){
    //file reading is done in the constructor 
    loadFromFile();
}

public void loadFromFile(){
      try {
    File myObj = new File("libinput.txt");
    Scanner myReader = new Scanner(myObj);

    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
       String[] parts=data.split(",");
      
      if(data.charAt(0)=='1')
      {
          Item nn=new book(parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]));
          ItemList.add(nn);
      }
      else if(data.charAt(0)=='2')
      {
        ArrayList<String> pubslist=new ArrayList<>();
        int i=2;
        while(parts[i].charAt(parts[i].length()-1)!='.')
        {
            pubslist.add(parts[i]);
            i++;
        }
        pubslist.add(parts[i]);
            i++;
         Item n1=new Magazine(parts[1],parts[i],pubslist,Integer.parseInt(parts[i+1]),Integer.parseInt(parts[i+2]));
         ItemList.add(n1);
      }
      else if(data.charAt(0)=='3')
      {
   

           Item nn=new Newspaper(parts[1],parts[2],Integer.parseInt(parts[3]),parts[4],0);
          ItemList.add(nn);
      }
    
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
}

public void displayMenu(){ 
    Scanner myobj=new Scanner(System.in);
   int choice=0;
    while(choice!=6){
         System.out.println("\n\n1. Add Items\n \n2. Edit Items\n3. Delete Item");
    System.out.println("4. View All Items\n5. View Item by ID\n6. Exit\n7.Borrow item\n8. Return item\n9.Hotpics \n Enter Choice: ");
     choice=myobj.nextInt();
    if(choice==1)
    {
       additem();
       choice=0;
    }
    else if(choice==2)
    {
        editItem();
         choice=0;

    }
    else if(choice==3)
    {
      deleteitem();
       choice=0;
    }
    else if(choice==4)
    {
       viewAll();
        choice=0;
    }
    else if(choice==5)
    {
       viewById();
        choice=0;
    }
    else if(choice==7)
    {
        borrowItem();
        viewBorrowers();
        choice=0;
    }
    else if(choice==8)
    {
        returnBorrow();
        choice=0;
    }
    else if(choice==9)
    {
        hotpics();
        choice=0;
    }
    else if(choice>9||choice<1)
    {
        System.out.println("INVALID RENTER");
        choice=0;
    }
    }}

public void additem(){
    Scanner myobj=new Scanner(System.in);
    System.out.print("1. Book\n2.Magazine\n3.Newspaper\nEnter Choice : ");
    int choice1=myobj.nextInt();
    
    if(choice1==1)
    {
         Scanner myobj1=new Scanner(System.in);
        System.out.print("\n Enter book title : ");
        String title=myobj1.nextLine();
        System.out.print("\n Enter Author name : ");
        String author=myobj1.nextLine();
        System.out.print("\nEnter publishing year : ");
        int year=myobj.nextInt();
        System.out.print("\nEnter popularity count : ");
        int popc=myobj.nextInt();
        System.out.print("\nEnter Cost : ");
        int c=myobj.nextInt();
        Item nn=new book(title,author,year,popc,c);
        ItemList.add(nn);
      
    }
    else if(choice1==2)
    {
        Scanner myobj1=new Scanner(System.in);
        System.out.print("\n Enter title : ");
        String title=myobj1.nextLine();
        System.out.print("\n Enter publisher name : ");
        String author=myobj1.nextLine();
        System.out.print("\nEnter popularity count : ");
        int popc=myobj.nextInt();
        System.out.print("\nEnter Cost : ");
        int c=myobj.nextInt();
        ArrayList<String> lists=new ArrayList<>();
        String reads="nothing";
        while(reads.charAt(0)!='x')
        {
            System.out.print("\n Enter Authors name or x to exit : ");
                reads=myobj1.nextLine();
            if(reads.charAt(0)!='x'){
            lists.add(reads);
            }
        }
        

        Item nn=new Magazine(title,author,lists,popc,c);
        ItemList.add(nn);

    }
    else if(choice1==3)
    {
         Scanner myobj1=new Scanner(System.in);
        System.out.print("\n Enter title : ");
        String title=myobj1.nextLine();
        System.out.print("\n Enter publisher name : ");
        String author=myobj1.nextLine();
        System.out.print("\nEnter publish date : ");
        String year=myobj1.nextLine();
        System.out.print("\nEnter popularity count : ");
        int popc=myobj.nextInt();
        System.out.print("\nEnter Cost : ");
        int c=myobj.nextInt();
        Item nn=new Newspaper(title,author,popc,year,c);
        ItemList.add(nn);
   

    }}

public void editItem(){
     Scanner myobj=new Scanner(System.in);
    System.out.println("To delete item enter ID : ");
    int id=myobj.nextInt();
    boolean check1=false;
      for(int i=0;i<ItemList.size();i++)
     {
        if(ItemList.get(i).getID()==id)
        {
           System.out.println("Item information  : ");
           ItemList.get(i).display();
            System.out.println("Press 1. to edit title\n 2. edit author / publisher \n : ");
           int id2=myobj.nextInt();
    if(id2==1)
    {
          Scanner myobj1=new Scanner(System.in);
          String nn=myobj1.nextLine();
          ItemList.get(i).setTitle(nn);
            System.out.println("UPDATED ");

    }
    else if(id2==2)
    {
       
    }


        }
     }
         if(check1==false)
     {
        System.out.println("ITEM NOT FOUND ID:"+id);
     }
}

public void deleteitem()
{
    Scanner myobj=new Scanner(System.in);
    System.out.println("To delete item enter ID : ");
    int id=myobj.nextInt();
    boolean check=false;
    for(int i=0;i<ItemList.size();i++)
     {
        if(ItemList.get(i).getID()==id)
        {
            ItemList.remove(i);
            check=true;
        }
     }
         if(check==false)
     {
        System.out.println("ITEM NOT FOUND ID:"+id);
     }
     myobj.close();
}

public void viewAll()
{
    for(int i=0;i<ItemList.size();i++)
    {
        ItemList.get(i).display();
    }
}

public void viewById()
{
    Scanner myobj=new Scanner(System.in);
    System.out.print("Enter ID to view Item : ");
    int id=myobj.nextInt();
    boolean check=false;
     for(int i=0;i<ItemList.size();i++)
     {
        if(ItemList.get(i).getID()==id)
        {
            ItemList.get(i).display();
            check=true;
        }
     }
     if(check==false)
     {
        System.out.println("ITEM NOT FOUND ID:"+id);
     }
    
}

public void viewByitem(Item item){
    item.display();}



public boolean borrowItem(){
    Scanner myobj=new Scanner(System.in);
    System.out.print("\nEnter ID to borrow Item : ");
    int id=myobj.nextInt();
     boolean check=false;
     for(int i=0;i<ItemList.size();i++)
     {
        if(ItemList.get(i).getID()==id)
        {
            if(ItemList.get(i).getBorrow()==false)
            {
                   Scanner myobj1=new Scanner(System.in);
                   System.out.print("\nEnter Your name to borrow : ");
                   String borrow=myobj1.nextLine();
                   for(int j=0;j<borrowers.size();j++ )
                   {
                         System.out.print("\nHERE ");
                             
                    if(borrowers.get(j).getname().equalsIgnoreCase(borrow))
                    {
                        
                        System.out.println(" \nYou are an existing borrower");
                        if(borrowers.get(j).checkExsiting(id)==false){
                        borrowers.get(j).addBorrowed(ItemList.get(i));
                        ItemList.get(i).setBorrow(true);
                        ItemList.get(i).popularityCount++;
                        return true;
                        }
                        return true;
                    }

                   }
                   if(check==false){
                   Borrower nn=new Borrower(borrow);
                   nn.addBorrowed(ItemList.get(i));
                   borrowers.add(nn);
                 ItemList.get(i).setBorrow(true);
                   ItemList.get(i).popularityCount++;
                   return true;
                   }

            }
            else
            {
                System.out.println("\nITEM ALREADY BORROWED");
            }
        }
     }

  return false;}


public void viewBorrowers(){
    for(int i=0;i<borrowers.size();i++)
    {
        borrowers.get(i).view();
    }
}

public void returnBorrow(){
     Scanner myobj=new Scanner(System.in);
    System.out.print("\nEnter ID to borrow Item : ");
    int id=myobj.nextInt();

    for(int i=0;i<ItemList.size();i++)
    {
       if(ItemList.get(i).getID()==id)
       {
        ItemList.get(i).setBorrow(false);
        System.out.print("\nReturned Succesfully : ");
       } 
    }}

public void hotpics()
{
    int n = ItemList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ItemList.get(j).popularityCount < ItemList.get(j + 1).popularityCount) {
                    // Swap elements if they are out of order
                    Item temp = ItemList.get(j);
                    ItemList.set(j, ItemList.get(j + 1));
                    ItemList.set(j + 1, temp);
                }
            }
        }

     viewAll();
    }



}

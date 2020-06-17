// אין צורך בהערות - לא להגשה

public class Supermarket {

	public static void main(String[] args) {
		
		// official tester 
		
		System.out.println("\n*********************** START OF STOCK TESTER**************************************");        
        // Stock        
        Date t1 = new Date(1,1,2000);
        Date t2 = new Date(1,1,2001);
        Date t3 = new Date(1,1,2002);
        FoodItem f1 = new FoodItem("Milk", 1111, 12, t1, t2, 7, 10, 5);
        FoodItem f2 = new FoodItem("Honey", 2222, 2, t1, t3, 6, 10, 20);
        FoodItem f3 = new FoodItem("PopCorn", 3333, 2, t1, t3, 6, 10, 12);

        Stock st = new Stock();
        st.addItem(f1);
        st.addItem(f2);
        st.addItem(f3);

        System.out.println("Testing method \"getNoOfItems\":");
        System.out.println("After adding 3 Food items to the Stock, the method \"getNoOfItems\" retuns: " + st.getNumOfItems()+"\n");//should print Honey and PopCorn 
        System.out.print("Testing method \"toString\" - ");
        System.out.println("the Stock looks like this:\n" + st);

        String list = st.order(5);
        System.out.println("This is the list to order (items quantity below 5) : " + list);//should print Honey and PopCorn                
        System.out.println("The number of items that can be store at 8 degrees are:  " + st.howMany(8));// should print 16
        System.out.println("the most expensive item on stock is:\n" + st.mostExpensive());// should print the Honey
        System.out.println("number of pieces in stock is: " + st.howManyPieces());// should print 16

        String[] updateList={"Milk","Milk"};
        System.out.println("\nUpdating Stock with {Milk,Milk}");
        st.updateStock(updateList);        
        System.out.println("list after update is (2 milks less in stock -> leaving 10 in the stock):\n"+ st);

        System.out.println("Min temperature of stock should be: " +st.getTempOfStock()); // should be 7

        Date t4 = new Date(1,6,2001);
        st.removeAfterDate (t4);
        System.out.println("deleting from stock all items with expiry date before (1/6/2001)\n"+
            "after deletion the stock looks like this (Milk should be deleted):\n" + st); 

        System.out.println("\n*********************** END OF STOCK TESTER**************************************");
		
		
		/*
		
		// checking //
		
		Date date = new Date(2, 3, 2019);
		Date date2 = new Date(4, 6, 2020);
		
		FoodItem food = new FoodItem("choclate", 24077, 4, date, date2, 10, 4, 2);
		FoodItem food2 = new FoodItem("choclate", 22222, 4, date, date2, 10, 4, 4);

		Stock s = new Stock();
		Stock s1 = new Stock();
		
		System.out.println(s +"\t"+ s1);
		System.out.println(food +"\t"+ food2);
		
		
		
		// tester -- works!
		Date d1 = new Date(18, 10, 2019);
        Date d2 = new Date(28, 10, 2019);
        Date d3 = new Date(8, 10, 2019);
        Date d4 = new Date(25, 10, 2019);
        Date d5 = new Date(10, 10, 2019);
        Date d6 = new Date(12, 10, 2019);
        Date d7 = new Date(14, 10, 2019);
        Date d8 = new Date(30, 10, 2019);

        //Creating FoodItem
        FoodItem milk = new FoodItem("milk", 1, 10, d1, d2, 20, 30, 5);
        FoodItem copyMilk = new FoodItem("milk", 1, 10, d1, d2, 20, 30, 5);
        FoodItem meat = new FoodItem("meat", 5, 3, d3, d4, 20, 50, 10);
        FoodItem bear = new FoodItem("bear", 6, 3, d7, d5, 100, 30, 25);
        FoodItem oreo = new FoodItem("oreo", 3, 3, d4, d6, 55, 30, 50);
        

        
        //checking aliasing
        d1.setYear(1900);
        d2.setYear(1950);
        
        System.out.println("Checking aliasing!!!");
        System.out.println("Should be false: " + d1.equals(milk.getProductionDate()));
        System.out.println("Should be false: " + d2.equals(milk.getExpiryDate()));
        System.out.println("Should be true: " + d3.equals(meat.getProductionDate()));
        System.out.println();

        
        //Checking toString
        System.out.println("Checking toString!!!");
        System.out.println(milk.toString());
        System.out.println();

        System.out.println(copyMilk.toString());
        System.out.println();
        
        System.out.println(meat.toString());
        System.out.println();
        
        System.out.println(bear.toString());
        System.out.println();
        
        System.out.println(oreo.toString());
        System.out.println();
        
        //Checking equals
        System.out.println("Checking equals");
        System.out.println("Should be true: " + milk.equals(copyMilk));
        System.out.println("Should be false: " + milk.equals(oreo));
        System.out.println("Should be false: " + milk.equals(meat));
        System.out.println();

        //Checking isfresh
        System.out.println("Checking isFresh");
        System.out.println("Should be true: " + milk.isFresh(d1));
        System.out.println("Should be true: " + milk.isFresh(d2));
        System.out.println("Should be true: " + milk.isFresh(d4)); 
        System.out.println("Should be false: " + milk.isFresh(d6));
        System.out.println("Should be false: " + milk.isFresh(d8));
        System.out.println();
        
        //Checking olderFoodItem
        System.out.println("Checking olderFoodItem");
        System.out.println("Should be false: " + milk.olderFoodItem(milk));
        System.out.println("Should be false: " + milk.olderFoodItem(copyMilk));
        System.out.println("Should be false: " + milk.olderFoodItem(meat)); 
        System.out.println("Should be true: " + milk.olderFoodItem(oreo));
        System.out.println("Should be true: " + meat.olderFoodItem(oreo));
        System.out.println();
        
        //Checking howManyItems
        System.out.println("Checking howManyItems");
        System.out.println("you have 20 NIS, a milk cost 5 NIS, U can buy 4 beer. you calculated: "+milk.howManyItems(20));
        System.out.println("you have 25 NIS, a milk cost 5 NIS, U can buy 5 milk. you calculated: "+milk.howManyItems(25));
        System.out.println("you have 12 NIS, a meat cost 10 NIS, U can buy 1 meat. you calculated: "+meat.howManyItems(12));
        System.out.println("you have 13 NIS, a oreo cost 50 NIS, U can buy 0 oreo. you calculated: "+oreo.howManyItems(13));
        System.out.println("you have 60 NIS, a milk cost 5 NIS, U can buy 12 milk but only 10 avalible. you calculated: "+milk.howManyItems(60));
        System.out.println("you have 150 NIS, a oreo ball cost 50 NIS, U can buy 3 oreo. you calculated: "+oreo.howManyItems(150));
		
		*/
	
	}
}

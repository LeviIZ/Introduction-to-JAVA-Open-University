public class StockTesterMY {

    public static void main(String[] args) {
        Date d1 = new Date(3, 5, 2011);
        Date d2 = new Date(1, 5, 2012);
        Date d3 = new Date(1, 8, 2013);
        Date d4 = new Date(5, 1, 2014);
        Date d5 = new Date(5, 3, 2015);
        Date d6 = new Date(8, 6, 2015);
        FoodItem f1 = new FoodItem("tomato1", 7000, 3, d1, d2,
                5, 40, 12);
        FoodItem f2 = new FoodItem("tomato2", 4000, 4, d1, d2,
                5, 40, 120);
        FoodItem f3 = new FoodItem("orange", 6000, 6, d3, d3.tomorrow(),
                5, 20, 50);
        FoodItem f4 = new FoodItem("orange", 6000, 3, d4, d5,
                5, 20, 50);
        FoodItem f5 = new FoodItem(f4);
        f5.setProductionDate(d3);
        f5.setQuantity(4);
        FoodItem f6 = new FoodItem("banana", 5500, 6, d1, d4,
                12, 28, 80);
        FoodItem f7 = new FoodItem("bread", 1234, 16, d2, d3,
                2, 35, 30);
        FoodItem f8 = new FoodItem("milk", 123456, 7, d5, d6,
                -1, 13, 14);
        FoodItem f9 = new FoodItem("milk", 123456789, 4, d5, d4,
                -1, 13, 14);

        // check constructor and addItem:

        Stock stock = new Stock();
        stock.addItem(f1);
        stock.addItem(f2);
        stock.addItem(f3);
        stock.addItem(f4);
        stock.addItem(f5);
        stock.addItem(f6);
        stock.addItem(f7);
        stock.addItem(f8);
        stock.addItem(f9);
        System.out.println(stock.addItem(f7));

        // check getNoOfItems
        System.out.println(stock.getNumOfItems());

        // check order
        System.out.println(stock.order(10000));

        // check howMany:
        System.out.println(stock.howMany(25));

        // check removeAfterDate:
        System.out.println(stock);
        stock.removeAfterDate(new Date(1,1,2014));
        System.out.println(stock);

        // check mostExpensive:
        System.out.println(stock.mostExpensive());

        // check howManyPieces:
        System.out.println(stock.howManyPieces());

        // check toString
        System.out.println(stock);

        // check updateStock:
        System.out.println(stock);
        String[] itemsList = {"tomato","banana","banana","orange","tomato","tomato","tomato","tomato"};
        stock.updateStock(itemsList);
        System.out.println(stock);

        // check getTempOfStock:
        System.out.println(stock.getTempOfStock());

    }
}

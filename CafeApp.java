public class CafeApp {
    
    public static void main(String[] args) {
        
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        Beverage latte = new Beverage("Iced Latte", 95.00, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.00, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110.00, "M-01", true, 1);

        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(30.00);
        cookie.setItemCode("P-02");

        Meal defaultMeal = new Meal();
        defaultMeal.setName("Rice Meal");
        defaultMeal.setBasePrice(100.00);
        defaultMeal.setItemCode("M-03");

        // Create the first order and demonstrate the three-item limit.
        Order order1 = new Order("1001", customer1);
        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie);

        latte.setBasePrice(-5);
        order1.printReceipt();

        
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80.00);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal("Beef Tapa", 130.00, "M-02", false, 0);

        Order order2 = new Order("1002", customer2);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.computeTotal(20.00);
        order2.printReceipt();
    }
}

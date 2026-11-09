/**
 * Runs the Campus Cafe Ordering System demonstration.
 * @author Romer Enardecido
 * @version 1.0
 */
public class CafeApp {
    /**
     * Creates sample customers, menu items, orders, and receipts.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Create customers using different overloaded constructors.
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        // Create a beverage, pastry, and meal using parameterized constructors.
        Beverage latte = new Beverage("Iced Latte", 95.00, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.00, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110.00, "M-01", true, 1);

        // Create default pastry and meal objects, then configure them with setters.
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

        // Demonstrate rejection of invalid data without changing the valid price.
        latte.setBasePrice(-5);
        order1.printReceipt();

        // Create a default beverage and fill it using setters.
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80.00);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        // Create the second meal with a parameterized constructor.
        Meal beefTapa = new Meal("Beef Tapa", 130.00, "M-02", false, 0);

        // Create the second order, apply a voucher, and print its receipt.
        Order order2 = new Order("1002", customer2);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.computeTotal(20.00);
        order2.printReceipt();
    }
}

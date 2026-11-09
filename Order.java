/**
 * Represents an order containing up to three menu items for one customer.
 * @author Romer Enardecido
 * @version 1.0
 */
public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private double appliedVoucher;

    /**
     * Creates an order for a customer.
     * @param orderId order identification
     * @param customer customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        item1 = null;
        item2 = null;
        item3 = null;
        itemCount = 0;
        appliedVoucher = 0.0;
    }

    /**
     * Adds a menu item to the first empty slot.
     * @param item menu item to add
     * @return true if added; otherwise false
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Invalid menu item.");
            return false;
        } else if (item1 == null) {
            item1 = item;
            itemCount++;
            return true;
        } else if (item2 == null) {
            item2 = item;
            itemCount++;
            return true;
        } else if (item3 == null) {
            item3 = item;
            itemCount++;
            return true;
        } else {
            System.out.println("Order is full. Cannot add "
                    + item.getName() + ".");
            return false;
        }
    }

    /**
     * Calculates the sum of all item prices.
     * @return order subtotal
     */
    public double computeSubtotal() {
        double subtotal = 0.0;
        // Each object uses its own overridden computePrice method.
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    /**
     * Calculates the total after a student discount, if applicable.
     * @return total after discount
     */
    public double computeTotal() {
        appliedVoucher = 0.0;
        double subtotal = computeSubtotal();
        // Students receive a 10 percent discount.
        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        } else {
            return subtotal;
        }
    }

    /**
     * Calculates the discounted total after subtracting a voucher.
     * @param voucher voucher amount in pesos
     * @return final total, never below zero
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();
        // Negative voucher values are not accepted.
        if (voucher < 0) {
            appliedVoucher = 0.0;
        } else {
            appliedVoucher = voucher;
        }
        total -= appliedVoucher;
        // A voucher cannot make the order total negative.
        if (total < 0) total = 0.0;
        return total;
    }

    /**
     * Prints the receipt and updates the customer's loyalty points.
     */
    public void printReceipt() {
        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0.0;
        double total = subtotal - discount - appliedVoucher;
        if (total < 0) total = 0.0;

        String studentLabel = customer.isStudent() ? " (Student)" : "";
        System.out.println("\\nOrder #" + orderId + " — "
                + customer.getName() + studentLabel);
        printItem(item1);
        printItem(item2);
        printItem(item3);
        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", discount);
        }
        if (appliedVoucher > 0) {
            System.out.printf("Voucher: -%.2f%n", appliedVoucher);
        }
        System.out.printf("TOTAL: %.2f%n", total);

        // Loyalty points are awarded from the final amount paid.
        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Prints one item and its computed price.
     * @param item item to print
     */
    private void printItem(MenuItem item) {
        if (item != null) {
            System.out.printf("%-43s %.2f%n",
                    item.getDescription(), item.computePrice());
        }
    }
}

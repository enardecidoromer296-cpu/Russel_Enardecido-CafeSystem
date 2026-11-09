/**
 * Abstract parent class for all campus cafe menu items.
 * @author Romer Enardecido
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /** Creates an unnamed menu item with a zero price and N/A code. */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
     * Creates a menu item with the supplied details.
     * @param name item name
     * @param basePrice item base price
     * @param itemCode item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Computes the final price for a particular menu item.
     * @return computed item price
     */
    public abstract double computePrice();

    /**
     * Returns the item's basic description.
     * @return item name and code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** @return the item name */
    public String getName() { return name; }

    /**
     * Updates the item name when the supplied value is valid.
     * @param name new item name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    /** @return the item's base price */
    public double getBasePrice() { return basePrice; }

    /**
     * Updates the base price; negative values are rejected.
     * @param basePrice new base price
     */
    public void setBasePrice(double basePrice) {
        // Reject a negative price and preserve the previous valid value.
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /** @return the item's code */
    public String getItemCode() { return itemCode; }

    /**
     * Updates the item code when it is not blank.
     * @param itemCode new item code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) this.itemCode = itemCode;
    }
}

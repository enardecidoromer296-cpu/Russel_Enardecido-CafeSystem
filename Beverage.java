/**
 * Represents a beverage whose price depends on its size.
 * @author Romer Enardecido
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

    /** Creates a small beverage with default menu-item values. */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Creates a beverage with the supplied details.
     * @param name beverage name
     * @param basePrice beverage base price
     * @param itemCode beverage code
     * @param size beverage size: S, M, or L
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Computes the price based on beverage size.
     * @return final beverage price
     */
    @Override
    public double computePrice() {
        // Large beverages add 25 pesos to the base price.
        if (size.equals("L")) {
            return basePrice + 25;
        // Medium beverages add 15 pesos to the base price.
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns the beverage description including its size.
     * @return beverage description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /** @return the beverage size */
    public String getSize() { return size; }

    /**
     * Sets the size only when it is S, M, or L.
     * @param size requested beverage size
     */
    public void setSize(String size) {
        if ("S".equals(size) || "M".equals(size) || "L".equals(size)) {
            this.size = size;
        }
    }
}
